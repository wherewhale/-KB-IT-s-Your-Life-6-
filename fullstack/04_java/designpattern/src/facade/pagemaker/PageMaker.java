package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {}

    //가장 밖에서 바라보는 Facade 역할 클래스
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

            // HTML 문서의 제목과 본문을 작성하여 메일로 보내는 HTML 파일을 생성한다.
            // 각 역할은 SRP (Single Responsibility Principle)에 따라 나누어져 있다.
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page.");
            writer.paragraph("We are looking forward to your visit.");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
