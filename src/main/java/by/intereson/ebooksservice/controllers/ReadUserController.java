package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.services.UserService;
import by.intereson.ebooksservice.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReadUserController extends HttpServlet{
private final UserService userService=new UserServiceImpl();//так делать не надо!

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users=userService.readUsers();
req.setAttribute("users",users);
req.getRequestDispatcher("/pages/users/users.jsp").forward(req,resp);
    }
}
