package by.intereson.ebooksservice.controllers.user;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.intereson.ebooksservice.enums.UserType.ADMIN;
import static by.intereson.ebooksservice.services.UserServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = USERS_DELETE_URL)
public class DeleteUserController extends HttpServlet {
    private final UserService userService = getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(ID) == null) {
            req.getRequestDispatcher(ERROR_ACCESS_PAGE).forward(req, resp);
        } else {
            List<User> users = userService.getUser(Integer.parseInt(req.getParameter(ID)));
            req.setAttribute(USERS, users);
            req.getRequestDispatcher(USERS_DELETE_PAGE).forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.readUser(Integer.parseInt(req.getParameter(ID)));
        if (user.getUserType() != ADMIN) {
            req.setAttribute(USER, user);
            userService.deleteUser(user);
            req.getRequestDispatcher(USERS_READ_URL).forward(req, resp);
        } else {
            req.getRequestDispatcher(USERS_READ_URL).forward(req, resp);
        }
    }
}
