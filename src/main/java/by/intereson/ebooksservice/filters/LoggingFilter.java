package by.intereson.ebooksservice.filters;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.intereson.ebooksservice.services.UserServiceImpl.getInstance;
import static by.intereson.ebooksservice.utils.Constants.ERROR_LOGIN_OR_PASSWORD;

@WebFilter(urlPatterns = "/users/create")
public class LoggingFilter extends HttpFilter {
    private final UserService userService = getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = userService.checkUserLogin(req);
        if(user!=null){
            req.getRequestDispatcher(ERROR_LOGIN_OR_PASSWORD).forward(req, res);
        }
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(86400);
        session.setAttribute("login",req.getParameter("login"));
        chain.doFilter(req, res);
    }
}
