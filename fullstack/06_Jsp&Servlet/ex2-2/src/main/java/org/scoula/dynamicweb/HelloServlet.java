package org.scoula.dynamicweb;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String linkLabel;

    public void init() {
        message = "Hello World!";
        linkLabel = "home";
    };

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html"); //헤더 수정 (contentType)

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"/\">" + linkLabel + "</a>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}