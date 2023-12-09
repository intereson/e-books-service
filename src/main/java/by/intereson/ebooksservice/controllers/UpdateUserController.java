package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.mappers.UserMapper;
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
import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = USERS_UPDATE_URL)
public class UpdateUserController extends HttpServlet {

    private final UserService userService = getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(ID) == null) {
            req.getRequestDispatcher(ERROR_ACCESS_PAGE).forward(req, resp);
        }
        List<User> users = userService.readUsers().stream()
                .filter(user -> user.getId() == Integer.parseInt(req.getParameter(ID)))
                .collect(Collectors.toList());
        req.setAttribute(USERS, users);
        req.getRequestDispatcher(USERS_UPDATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.readUser(Integer.parseInt(req.getParameter(ID)));
        req.setAttribute(USER, user);
        User userNew = UserMapper.getInstance().buildUser(req);
        userService.updateUser(user, userNew);
        req.getRequestDispatcher(USERS_READ_URL).forward(req, resp);
    }
}
