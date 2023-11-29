package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.services.UserService;
import by.intereson.ebooksservice.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users/read")
public class ReadUserController extends HttpServlet {
    private static final String USERS_PAGE = "/pages/users/users.jsp";
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.readUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher(USERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
