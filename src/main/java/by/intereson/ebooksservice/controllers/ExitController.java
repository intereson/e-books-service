package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.services.BookService;
import by.intereson.ebooksservice.services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = EXIT_URL)
public class ExitController extends HttpServlet {
    private final BookService bookService = BookServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        List<Book> books = bookService.readBooks();
        req.setAttribute(BOOKS, books);
        req.getRequestDispatcher(MAIN_PAGE_URL).forward(req,resp);
    }
}
