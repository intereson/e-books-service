package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static by.intereson.ebooksservice.services.BookServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.*;


@WebServlet(urlPatterns = BOOKS_DELETE_URL)
public class DeleteBookController extends HttpServlet {

    private final BookService bookService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.readBooks().stream()
                .filter(user -> user.getId() == Integer.parseInt(req.getParameter(ID)))
                .collect(Collectors.toList());
        req.setAttribute(BOOKS, books);
        req.getRequestDispatcher(BOOKS_DELETE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bookService.readBook(Integer.parseInt(req.getParameter(ID)));

        req.setAttribute(BOOK, book);
        bookService.deleteBook(book);
        req.getRequestDispatcher(BOOKS_READ_URL).forward(req, resp);
    }
}
