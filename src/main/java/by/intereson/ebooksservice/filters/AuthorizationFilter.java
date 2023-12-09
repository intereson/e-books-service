package by.intereson.ebooksservice.filters;

import by.intereson.ebooksservice.entities.Book;
import by.intereson.ebooksservice.entities.UserType;
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

import static by.intereson.ebooksservice.entities.UserType.ADMIN;
import static by.intereson.ebooksservice.entities.UserType.USER;
import static by.intereson.ebooksservice.utils.Constants.*;

@WebFilter(urlPatterns = {"/users/delete","/users/read","/books/*"})
public class AuthorizationFilter extends HttpFilter {
    private final BookService bookService = BookServiceImpl.getInstance();
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        UserType userType = (UserType) req.getSession().getAttribute("userType");
        if(userType==ADMIN){
            chain.doFilter(req,res);
        }
        if(userType==USER){
            List<Book> books = bookService.readBooks();
            req.setAttribute("books", books);
            req.getRequestDispatcher(BOOKS_PAGE_FOR_LOGGING_USER).forward(req,res);
        }
        if(userType==null){

            req.getRequestDispatcher(ERROR_ACCESS_PAGE).forward(req,res);
        } else {
            req.getRequestDispatcher(ERROR_LOGIN_OR_EMAIL).forward(req,res);
        }

    }
}
