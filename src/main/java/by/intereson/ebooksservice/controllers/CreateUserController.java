package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.mappers.UserMapper;
import by.intereson.ebooksservice.services.BookService;
import by.intereson.ebooksservice.services.BookServiceImpl;
import by.intereson.ebooksservice.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.intereson.ebooksservice.services.UserServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.BOOKS_PAGE_FOR_LOGGING_USER;
import static by.intereson.ebooksservice.utils.Constants.ERROR_DATA_PAGE;

@WebServlet(urlPatterns = "/users/create")

public class CreateUserController extends HttpServlet {

    private final UserService userService = getInstance();
    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserMapper.userMapper.buildUser(req);
        userService.createUser(user);
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(86400);
        session.setAttribute("login", req.getParameter("login"));
        session.setAttribute("password", req.getParameter("password"));
        List<Book> books = bookService.readBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher(BOOKS_PAGE_FOR_LOGGING_USER).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
