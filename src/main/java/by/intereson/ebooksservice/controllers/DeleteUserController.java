package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static by.intereson.ebooksservice.entities.UserType.ADMIN;
import static by.intereson.ebooksservice.services.UserServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.DELETE_USERS_PAGE;
import static by.intereson.ebooksservice.utils.Constants.ERROR_ACCESS_PAGE;

@WebServlet(urlPatterns = "/users/delete")
public class DeleteUserController extends HttpServlet {
    private final UserService userService = getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") == null) {
            req.getRequestDispatcher(ERROR_ACCESS_PAGE).forward(req, resp);
        }
        List<User> users = userService.readUsers().stream()
                .filter(user -> user.getId() == Integer.parseInt(req.getParameter("id")))
                .collect(Collectors.toList());
        req.setAttribute("users", users);
        req.getRequestDispatcher(DELETE_USERS_PAGE).forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.readUser(Integer.parseInt(req.getParameter("id")));
        if (user.getUserType() != ADMIN) {
            req.setAttribute("user", user);
            userService.deleteUser(user);
            req.getRequestDispatcher("/users/read").forward(req, resp);
        } else {
            req.getRequestDispatcher("/users/read").forward(req, resp);
        }

    }

}
