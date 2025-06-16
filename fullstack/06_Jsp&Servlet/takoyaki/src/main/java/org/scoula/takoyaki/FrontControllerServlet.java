package org.scoula.takoyaki;

import org.scoula.takoyaki.command.Command;
import org.scoula.takoyaki.controller.HomeController;
import org.scoula.takoyaki.controller.MenuController;
import org.scoula.takoyaki.dispatcher.DispatcherServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet {
    private final HomeController homeController = new HomeController();
    private final MenuController menuController = new MenuController();

    private final String prefix = "/WEB-INF/views/";
    private final String suffix = ".jsp";

    @Override
    public void init() {
        super.init(); // DispatcherServlet: menuList, revenue, inventory 초기화

        // Command 라우팅 등록
        getMap.put("/", homeController::getIndex);
        getMap.put("/menu/list", menuController::getList);
        getMap.put("/menu/add", menuController::getAddForm);
        getMap.put("/order/new", menuController::getNewOrder);

        postMap.put("/menu/add", menuController::postAdd);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        Command command = getCommand(req);
        if (command != null) {
            execute(command, req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // 404 처리
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        doGet(req, resp); // POST도 동일하게 처리
    }

    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest req) {
        String commandName = getCommandName(req);
        if (req.getMethod().equalsIgnoreCase("GET")) {
            return getMap.get(commandName);
        } else {
            return postMap.get(commandName);
        }
    }

    private void execute(Command command, HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String viewName = command.execute(req, resp);
        if (viewName.startsWith("redirect:")) {
            resp.sendRedirect(viewName.substring("redirect:".length()));
        } else {
            String viewPath = prefix + viewName + suffix;
            RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
            dispatcher.forward(req, resp);
        }
    }
}
