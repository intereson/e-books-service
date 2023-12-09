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

@WebServlet(urlPatterns = BOOKS_CREATE_URL)
public class CreateBookController extends HttpServlet {
    private final BookService bookService = getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(BOOK_CREATE_PAGE).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((req.getParameter(BOOK_NAME).isEmpty())
                || (req.getParameter(AUTHOR).isEmpty()) ||(req.getParameter(YEAR_OF_PUBLISHING).isEmpty())|| (req.getParameter(PUBLISHING_HOUSE).isEmpty())||(req.getParameter(ANNOTATION).isEmpty())||(req.getParameter(PRICE).isEmpty())
        ) {
            req.getRequestDispatcher(ERROR_DATA_BOOK_PAGE).forward(req, resp);
        } else {
        Book book=BookMapper.getInstance().buildBook(req);
        bookService.createBook(book);
        req.getRequestDispatcher(BOOKS_READ_URL).forward(req,resp);
    }
}}
