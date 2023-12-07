package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.entities.UserType;
import by.intereson.ebooksservice.services.UserService;
import by.intereson.ebooksservice.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = "/users/authentication")
public class AccessUserController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AUTHENTICATION_USER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.checkUserLogin(req);
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("userType", user.getUserType());
            session.setMaxInactiveInterval(86400);
            session.setAttribute("login", req.getParameter("login"));
            if (user.getUserType() == UserType.ADMIN) {
                req.getRequestDispatcher("/books/read").forward(req, resp);
            }
            if (user.getUserType() == UserType.USER) {
                req.getRequestDispatcher("/books").forward(req, resp);
            }
        }
        req.getRequestDispatcher(ERROR_LOGIN_OR_PASSWORD).forward(req, resp);
    }
}
