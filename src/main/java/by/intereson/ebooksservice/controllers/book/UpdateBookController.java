package by.intereson.ebooksservice.controllers.book;

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

import static by.intereson.ebooksservice.services.BookServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = BOOKS_UPDATE_URL)
public class UpdateBookController extends HttpServlet {
    private final BookService bookService = getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> book = bookService.getBook(Integer.parseInt(req.getParameter(ID)));
        req.setAttribute(BOOKS, book);
        req.getRequestDispatcher(BOOKS_UPDATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (bookService.checkBookData(req)) {
            Book book = bookService.readBook(Integer.parseInt(req.getParameter(ID)));
            req.setAttribute(BOOK, book);
            req.setAttribute(PRICE,bookService.getPrice(req));
            Book bookNew = BookMapper.getInstance().buildBook(req);
            bookService.updateBook(book, bookNew);
            req.getRequestDispatcher(BOOKS_READ_URL).forward(req, resp);
        } else {
            req.getRequestDispatcher(ERROR_DATA_BOOK_PAGE).forward(req, resp);
        }
    }
}
