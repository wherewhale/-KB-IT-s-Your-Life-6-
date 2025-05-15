package facade.pagemaker;

import java.io.IOException;
import java.io.Writer;

public class HtmlWriter {
    private Writer writer;

    //DI (Dependency Injection) : HtmlWriter는 Writer를 DI로 주입받는다.
    //OCP (Open-Closed Principle) : HtmlWriter는 Writer를 DI로 주입받기 때문에, Writer의 구현체가 변경되어도 HtmlWriter는 변경되지 않는다.
    public HtmlWriter(Writer writer) {
        // 그냥 new FileWriter()로 생성해도 될텐데 왜 DI로 주입받는가?
        // FileWriter를 new로 생성하면, HtmlWriter는 FileWriter에 의존하게 된다.
        // writer를 받게 되면 매체에만 의존하지 않고 추상화된 요소를 사용할 수 있게 된다.
        // 또한, new FileWriter()로 계속 생성하면 자원 낭비가 발생하여 성능이 저하된다.
        this.writer = writer;
    }

    //타이틀 출력
    public void title(String title) throws IOException {
        writer.write("<!DOCTYPE html>"); //각 줄 하나하나가 모두 퍼사드 패턴이라고볼 수 있음
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("\n");
        writer.write("<h1>" + title + "</h1>");
        writer.write("\n");
    }

    // 단락 출력
    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>");
        writer.write("\n");
    }

    // 링크 출력
    public void link(String href, String caption) throws IOException {
        paragraph("<a href=\"" + href + "\">" + caption + "</a>");
    }

    // 이메일 주소 출력
    public void mailto(String mailaddr, String username) throws IOException {
        link("mailto:" + mailaddr, username);
    }

    // HTML 문서 끝내기
    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>");
        writer.write("\n");
        writer.close();
    }
}
