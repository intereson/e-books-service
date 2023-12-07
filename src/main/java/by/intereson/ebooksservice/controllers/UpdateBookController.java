package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.mappers.BookMapper;
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
import static by.intereson.ebooksservice.utils.Constants.UPDATE_BOOKS_PAGE;

@WebServlet(urlPatterns = "/books/update")
public class UpdateBookController extends HttpServlet {
    private final BookService bookService = getInstance();
    private long id;
    private final BookMapper bookMapper=new BookMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));
        List<Book> books = bookService.readBooks().stream()
                .filter(book -> book.getId() == id)
                .collect(Collectors.toList());
        req.setAttribute("books", books);
        req.getRequestDispatcher(UPDATE_BOOKS_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bookService.readBook(id);
        req.setAttribute("book", book);
        Book bookNew = bookMapper.buildBook(req);
        bookService.updateBook(book, bookNew);
        req.getRequestDispatcher("/books/read").forward(req, resp);
    }
}
