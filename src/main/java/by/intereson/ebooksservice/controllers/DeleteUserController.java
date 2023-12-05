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

import static by.intereson.ebooksservice.services.UserServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.DELETE_USERS_PAGE;

@WebServlet(urlPatterns = "/users/delete")
public class DeleteUserController extends HttpServlet {
    private final UserService userService = getInstance();

    private long id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        List<User> users = userService.readUsers().stream()
                .filter(user -> user.getId() == id)
                .collect(Collectors.toList());
        req.setAttribute("users", users);
        req.getRequestDispatcher(DELETE_USERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.readUser(id);
        req.setAttribute("user", user);
        userService.deleteUser(user);
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }
}
