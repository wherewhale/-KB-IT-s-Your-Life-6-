package org.scoula.takoyaki.controller;

import org.scoula.takoyaki.dispatcher.DispatcherServlet;
import org.scoula.takoyaki.model.Menu;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MenuController {
    List<Menu> list = new ArrayList<>();

    public String getList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext sc = req.getServletContext();
        List<Menu> list = (List<Menu>) sc.getAttribute("menuList");
        req.setAttribute("menuList", list);
        System.out.println("GET /menu/list");
        return "menu/list";
    }

    public String getAddForm(HttpServletRequest req, HttpServletResponse resp) {
        return "menu/add"; // menu/addForm.jsp 로 forward
    }

    public String getNewOrder(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext sc = req.getServletContext();
        List<Menu> list = (List<Menu>) sc.getAttribute("menuList");

        if (list == null || list.isEmpty()) {
            req.setAttribute("error", "등록된 메뉴가 없습니다.");
            return "order/error";
        }

        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        Menu randomMenu = list.get(randomIndex);
        req.setAttribute("randomMenu", randomMenu);

        return "order/new";
    }


    public String postAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = (String)req.getParameter("name");
        String priceParam = req.getParameter("price");
        int price = Integer.parseInt(priceParam);

        System.out.println("POST /menu/add");
        list.add(new Menu(name, price));
        return "redirect:/menu/list";
    }
}
