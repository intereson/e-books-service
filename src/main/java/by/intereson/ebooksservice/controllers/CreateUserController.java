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

import static by.intereson.ebooksservice.services.UserServiceImpl.getInstance;

@WebServlet(urlPatterns = "/users/create")

public class CreateUserController extends HttpServlet {
    private final UserService userService = getInstance();
    private final UserMapper userMapper = new UserMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userMapper.buildUser(req);
        userService.createUser(user);
        req.getRequestDispatcher("/users/read").forward(req, resp);
    }

}
