package practice13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserFileService {
    public static UserInfo loadUserInfo() {
        String name = "";
        String birth = "";

        try (BufferedReader br = new BufferedReader(
                new FileReader("/Users/son-yeongho/Desktop/Work/공부/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/user_input.txt")
        )) {

            String[] tempBuffer = br.readLine().split(": ");
            name = tempBuffer[1];

            tempBuffer = br.readLine().split(": ");
            birth = tempBuffer[1];
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return new UserInfo(name, birth);
    }

    public static void saveSajuToFile(String birth) {
        String data = SajuCalculator.formatSaju(birth);

        File file = new File("/Users/wha1e/Documents/Develop/IT's Your Life/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/fortune_saju.txt");

        try {
            if (file.exists()) {
                long lastModified = file.lastModified(); // ms 단위
                Date date = new Date(lastModified);      // Date 객체로 변환

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);


                System.out.println("\uD83D\uDCC4 이전 사주 파일이 존재합니다.");
                System.out.println("\uD83D\uDCCD 경로: " + file.getAbsolutePath());
                System.out.println("\uD83D\uDCE6 크기: " + file.length() + "bytes");
                System.out.println("\uD83D\uDD01 이전 파일이 fortune_saju_backup.txt로 백업되었습니다.");
                System.out.println("⏰ 마지막 수정: " + formattedDate);
                file.renameTo(new File("/Users/wha1e/Documents/Develop/IT's Your Life/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/fortune_saju_backup.txt"));
            }

            Files.writeString(Paths.get("/Users/wha1e/Documents/Develop/IT's Your Life/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/fortune_saju.txt"), data, Charset.forName("UTF-8"));
            System.out.println("✅ 새로운 사주 결과가 fortune_saju.txt에 저장되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
