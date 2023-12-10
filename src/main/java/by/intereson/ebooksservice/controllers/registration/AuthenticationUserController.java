package by.intereson.ebooksservice.controllers.registration;

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

import static by.intereson.ebooksservice.enums.UserType.ADMIN;
import static by.intereson.ebooksservice.enums.UserType.USER;
import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = USERS_AUTHENTICATION_URL)
public class AuthenticationUserController extends HttpServlet {
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(USERS_AUTHENTICATION_PAGE).forward(req, resp);
    }

    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String pass = req.getParameter(PASSWORD);
        if (userService.checkUserLoginAndPass(login, pass)) {
            User user = userService.getUserForLogin(req);
            HttpSession session = req.getSession(true);
            session.setAttribute(USER_TYPE, user.getUserType());
            session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL_SESSION);
            session.setAttribute(LOGIN, req.getParameter(LOGIN));
            if (user.getUserType() == ADMIN) {
                req.getRequestDispatcher(BOOKS_READ_URL).forward(req, resp);
            }
            if (user.getUserType() == USER) {
                List<Book> books = bookService.readBooks();
                req.setAttribute(BOOKS, books);
                req.getRequestDispatcher(BOOKS_FOR_LOGGING_USER_PAGE).forward(req, resp);
            }
        } else {
            req.getRequestDispatcher(ERROR_LOGIN_OR_EMAIL_PAGE).forward(req, resp);
        }
    }
}
