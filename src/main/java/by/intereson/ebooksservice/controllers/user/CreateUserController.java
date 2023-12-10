package by.intereson.ebooksservice.controllers.user;

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
import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = USERS_CREATE_URL)

public class CreateUserController extends HttpServlet {

    private final UserService userService = getInstance();
    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserMapper.userMapper.buildUser(req);
        userService.createUser(user);
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL_SESSION);
        session.setAttribute(LOGIN, req.getParameter(LOGIN));
        session.setAttribute(PASSWORD, req.getParameter(PASSWORD));
        List<Book> books = bookService.readBooks();
        req.setAttribute(BOOKS, books);
        req.getRequestDispatcher(BOOKS_FOR_LOGGING_USER_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
