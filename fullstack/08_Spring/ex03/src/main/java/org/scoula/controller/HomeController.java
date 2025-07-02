package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "홍길동");
        return "index"; // View의 이름
    }

}
