package org.scoula.lunch;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "lunchServlet", value = "/lunch")
public class LunchServlet extends HttpServlet {
    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지

        String selectedMood = request.getParameter("mood");
        String recommendFood = "";

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (selectedMood == null || selectedMood.isEmpty()) {
            out.println("<html><body>");
            out.println("<h1>오늘 기분은 어떤가요?</h1>");
            out.println("<form method=\"get\">");
            out.println("<select name=\"mood\" id=\"lang\">");
            out.println("<option value=\"happy\">기분 최고야</option>");
            out.println("<option value=\"soso\">그냥 그래</option>");
            out.println("<option value=\"sad\">우울해</option>");
            out.println("<option value=\"stressed\">스트레스 쩔어</option>");
            out.println("<option value=\"etc\">기타</option>");
            out.println("</select>");
            out.println("<button>추천 받기</button>");
            out.println("</form>");
            out.println("</body></html>");
        } else {
            switch (selectedMood) {
                case "happy":
                    recommendFood = "\uD83D\uDC19 매콤한 쭈꾸미볶음 추천!";
                    break;
                case "soso":
                    recommendFood = "\uD83E\uDD58 든든한 김치찌개 어떠세요?";
                    break;
                case "sad":
                    recommendFood = "\uD83C\uDF5D 부드러운 크림파스타로 위로받으세요.";
                    break;
                case "stressed":
                    recommendFood = "\uD83D\uDD25 부대찌개 한 냄비 추천드려요!";
                    break;
                default:
                    recommendFood = "\uD83C\uDF71 오늘은 도시락도 괜찮아요!";
                    break;
            }
            out.println("<h1>오늘의 추천 메뉴 🍽️</h1>");
            out.println("<p>" + recommendFood + "</p>");
            out.println("<a href=\"/lunch\"> 다시 선택하기 </a>");

        }
    }
    public void destroy() {
    }
}
