package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.dto.SurveyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/survey")
@Log4j2
public class SurveyController {

    // 간단한 인메모리 저장소
    private final Map<Long, SurveyDTO> surveyStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // 1. 설문 폼 보여주기
    @GetMapping
    public String showForm() {
        return "survey/form"; // => /WEB-INF/views/form.jsp
    }

    // 2. 설문 응답 처리 및 저장
    @PostMapping
    public String submitSurvey(@ModelAttribute SurveyDTO surveyDTO) {
        long id = idGenerator.getAndIncrement();
        surveyStore.put(id, surveyDTO);
        return "redirect:survey/share?id=" + id;
    }

    // 3. 공유 페이지 보여주기
    @GetMapping("/share")
    public String showShare(@RequestParam("id") Long id, Model model) {
        SurveyDTO dto = surveyStore.get(id);

        if (dto == null) {
            return "/error/404"; // => /WEB-INF/views/error/404.jsp
        }

        model.addAttribute("survey", dto);
        model.addAttribute("id", id);

        return "survey/share"; // => /WEB-INF/views/share.jsp
    }

    @GetMapping("upload")
    public String showUpload(@RequestParam("id") Long id, Model model) {
        if (id == null) {
            return "/error/404"; // => /WEB-INF/views/error/404.jsp
        }
        model.addAttribute("id", id);

        return "survey/upload"; // => /WEB-INF/views/form.jsp
    }

    @PostMapping("upload")
    public String multipartUploadFile(@RequestParam("file") MultipartFile file,
                                      @RequestParam("id") Long id,
                                      HttpServletRequest request) throws IOException {

        if (file.isEmpty()) {
            log.warn("빈 파일 업로드 시도됨");
            return "redirect:/error/404";
        }

        // 저장 경로 계산
        String uploadDir = request.getServletContext().getRealPath("/resources/uploads/");
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs(); // macOS 환경 포함
        }

        // 저장 파일명 생성
        String originalFilename = file.getOriginalFilename();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String savedFilename = id + "_" + timestamp + "_" + originalFilename;

        // 파일 저장
        File destination = new File(dir, savedFilename);
        file.transferTo(destination);
        log.info("파일 저장 완료: " + destination.getAbsolutePath());

        // 성공 시 report 페이지로 리다이렉트
        return "redirect:/survey/report?id=" + id;
    }


    @GetMapping("/report")
    public String showReport(@RequestParam("id") Long id,
                             HttpServletRequest request,
                             Model model) {

        // 업로드 폴더 경로
        String uploadDir = request.getServletContext().getRealPath("/resources/uploads/");
        File dir = new File(uploadDir);

        if (!dir.exists() || !dir.isDirectory()) {
            log.warn("업로드 디렉토리가 존재하지 않음: " + uploadDir);
            return "/error/404";
        }

        // id로 시작하는 파일들 필터링
        File[] matchedFiles = dir.listFiles((d, name) -> name.startsWith(id + "_"));
        if (matchedFiles == null || matchedFiles.length == 0) {
            log.warn("해당 ID로 업로드된 파일 없음: " + id);
            return "/error/404";
        }

        // 최신 파일 찾기 (타임스탬프가 포함되어 있으므로 정렬)
        File latestFile = Arrays.stream(matchedFiles)
                .max(Comparator.comparing(File::getName)) // 파일명 자체를 비교 (id_timestamp_원본명)
                .orElse(null);

        if (latestFile == null) {
            return "/error/404";
        }

        SurveyDTO dto = surveyStore.get(id);

        if (dto == null) {
            return "/error/404"; // => /WEB-INF/views/error/404.jsp
        }

        model.addAttribute("survey", dto);
        // JSP에서 출력할 상대경로 전달
        String webPath = "/resources/uploads/" + latestFile.getName();
        model.addAttribute("imagePath", webPath);


        return "survey/report"; // => /WEB-INF/views/survey/report.jsp
    }

}


