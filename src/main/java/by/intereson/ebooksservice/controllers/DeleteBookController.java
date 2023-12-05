package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.entities.User;
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
import static by.intereson.ebooksservice.utils.Constants.DELETE_BOOKS_PAGE;


@WebServlet(urlPatterns = "/books/delete")
public class DeleteBookController extends HttpServlet {

    private final BookService bookService = getInstance();
    private long id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        List<Book> books = bookService.readBooks().stream()
                .filter(user -> user.getId() == id)
                .collect(Collectors.toList());
        req.setAttribute("books", books);
        req.getRequestDispatcher(DELETE_BOOKS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book= bookService.readBook(id);

        req.setAttribute("book", book);
        bookService.deleteBook(book);
        req.getRequestDispatcher("/books/read").forward(req, resp);
    }
}
