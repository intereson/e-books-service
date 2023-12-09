package by.intereson.ebooksservice.controllers;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.mappers.BookMapper;
import by.intereson.ebooksservice.services.BookService;

import static by.intereson.ebooksservice.services.BookServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/books/create")
public class CreateBookController extends HttpServlet {
    private final BookService bookService = getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CREATE_BOOK).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((req.getParameter("bookName").isEmpty())
                || (req.getParameter("author").isEmpty()) || (req.getParameter("price").isEmpty())
        ) {
            req.getRequestDispatcher(ERROR_DATA_BOOK_PAGE).forward(req, resp);
        } else {
        Book book=BookMapper.getInstance().buildBook(req);
        bookService.createBook(book);
        req.getRequestDispatcher("/books/read").forward(req,resp);
    }
}}
