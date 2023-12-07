package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.services.BookService;
import by.intereson.ebooksservice.services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.intereson.ebooksservice.utils.Constants.BOOKS_PAGE_FOR_USER;

@WebServlet(urlPatterns = "/books")
public class ReadBookForUserController extends HttpServlet {


    private final BookService bookService = BookServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.readBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher(BOOKS_PAGE_FOR_USER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
