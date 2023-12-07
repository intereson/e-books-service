package by.intereson.ebooksservice.filters;

import by.intereson.ebooksservice.entities.UserType;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.intereson.ebooksservice.entities.UserType.ADMIN;
import static by.intereson.ebooksservice.entities.UserType.USER;
import static by.intereson.ebooksservice.utils.Constants.ERROR_LOGIN_OR_PASSWORD;

@WebFilter(urlPatterns = {"/users/delete","/users/read","/books/read","/books/create","/books/delete","/books/update"})
public class AuthorizationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        UserType userType = (UserType) req.getSession().getAttribute("userType");
        if(userType==ADMIN){
            chain.doFilter(req,res);
        }
        if(userType==USER){
            req.getRequestDispatcher("/books").forward(req,res);
        }
        req.getRequestDispatcher(ERROR_LOGIN_OR_PASSWORD).forward(req,res);
    }
}
