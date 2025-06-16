package org.snack.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        Cookie cookie = new Cookie("lastSnack", "");

        cookie.setMaxAge(0); // 즉시 삭제
        res.addCookie(cookie);

        res.sendRedirect("vote-form");
    }
}
