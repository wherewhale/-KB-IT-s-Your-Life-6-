package org.scoula.lunch;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "randomLunchServlet", value = "/lunch/random")
public class RandomLunchServlet extends HttpServlet {
    static Map<String, int[]> menuMap = new HashMap<>();

    public void init() {
        //쭈꾸미볶음, 김치찌개, 크림파스타, 부대찌개, 햄버거, 제육볶음
        menuMap.put("쭈꾸미볶음", new int[2]);
        menuMap.put("김치찌개", new int[2]);
        menuMap.put("크림파스타", new int[2]);
        menuMap.put("부대찌개", new int[2]);
        menuMap.put("햄버거", new int[2]);
        menuMap.put("제육볶음", new int[2]);
    }

    public String getRandomMenu() {
        // 랜덤 키 하나 가져오기
        List<String> keys = new ArrayList<>(menuMap.keySet());
        Random rand = new Random();
        return keys.get(rand.nextInt(keys.size()));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지

        String recommendFood = getRandomMenu();
        String vote = request.getParameter("vote");
        String selectedMenu = request.getParameter("menu");
        int like = 0, dislike = 0;

        if(selectedMenu != null && !selectedMenu.isEmpty()) {
            if(!vote.isEmpty()) {
                if(vote.equals("like")) {
                    menuMap.get(selectedMenu)[0]++;
                } else {
                    menuMap.get(selectedMenu)[1]++;
                }
            }

            like = menuMap.get(selectedMenu)[0];
            dislike = menuMap.get(selectedMenu)[1];
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(selectedMenu == null || selectedMenu.isEmpty()) {
            out.println("<html><body>");
            out.println("<h1>오늘의 점심 메뉴 추천🍽️</h1>");
            out.println("<b>" + recommendFood + "</b>");
            out.println("<div>");
            //?menu=김치찌개&vote=like
            out.println("<a href=\"/lunch/random?menu=" + recommendFood + "&vote=like\">좋아요</a>");
            out.println("<a href=\"/lunch/random?menu=" + recommendFood + "&vote=dislike\">싫어요</a>");

            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>🍽️\'" + selectedMenu + "\' 메뉴에 대한 투표 결과</h1>");
            out.println("<p> 좋아요 : " + like + "</p>");
            out.println("<p> 싫어요 : " + dislike + "</p>");
            out.println("<div>");
            //?menu=김치찌개&vote=like
            out.println("<a href=\"/lunch/random\">다시 추천 받기</a>");

            out.println("</body></html>");
        }
    }

        public void destroy() {
    }

}

