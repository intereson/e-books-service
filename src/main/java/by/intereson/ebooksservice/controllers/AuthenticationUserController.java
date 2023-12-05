package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.services.UserService;
import by.intereson.ebooksservice.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = "/users/authentication")
public class AuthenticationUserController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AUTHENTICATION_USER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(userService.checkUser(req)){
            req.getRequestDispatcher("/books/read").forward(req,resp);
        }
        req.getRequestDispatcher(ERROR_LOGIN_OR_PASSWORD).forward(req,resp);
    }
}
