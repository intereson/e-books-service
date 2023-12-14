package by.intereson.ebooksservice.filters;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.enums.UserType;
import by.intereson.ebooksservice.services.BookService;
import by.intereson.ebooksservice.services.BookServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.intereson.ebooksservice.enums.UserType.ADMIN;
import static by.intereson.ebooksservice.enums.UserType.USER;
import static by.intereson.ebooksservice.utils.Constants.*;

@WebFilter(urlPatterns = {USERS_DELETE_URL, USERS_READ_URL,"/books/*"})
public class AccessFilter extends HttpFilter {
    private final BookService bookService = BookServiceImpl.getInstance();
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        UserType userType = (UserType) req.getSession().getAttribute(USER_TYPE);
        if(userType==ADMIN){
            chain.doFilter(req,res);
        }
        if(userType==USER){
            List<Book> books = bookService.readBooks();
            req.setAttribute(BOOKS, books);
            req.getRequestDispatcher(BOOKS_FOR_LOGGING_USER_PAGE).forward(req,res);
        }
        if(userType==null){
            req.getRequestDispatcher(ERROR_ACCESS_PAGE).forward(req,res);
        } else {
            req.getRequestDispatcher(ERROR_ACCESS_PAGE).forward(req,res);
        }
    }
}
