package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.services.BookService;
import by.intereson.ebooksservice.services.BookServiceImpl;
import by.intereson.ebooksservice.services.UserService;
import by.intereson.ebooksservice.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.intereson.ebooksservice.entities.UserType.ADMIN;
import static by.intereson.ebooksservice.entities.UserType.USER;
import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = "/users/authentication")
public class AuthenticationUserController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(AUTHENTICATION_USER).forward(req, resp);
    }

    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        if (userService.checkUserLoginAndPass(login, pass)) {
            User user = userService.getUserForLogin(req);
            HttpSession session = req.getSession(true);
            session.setAttribute("userType", user.getUserType());
            session.setMaxInactiveInterval(86400);
            session.setAttribute("login", req.getParameter("login"));
            if (user.getUserType() == ADMIN) {
                req.getRequestDispatcher("/books/read").forward(req, resp);
            }
            if (user.getUserType() == USER) {
                List<Book> books = bookService.readBooks();
                req.setAttribute("books", books);
                req.getRequestDispatcher(BOOKS_PAGE_FOR_LOGGING_USER).forward(req, resp);
            }
        } else {
            req.getRequestDispatcher(ERROR_LOGIN_OR_EMAIL).forward(req, resp);
        }
    }
}
