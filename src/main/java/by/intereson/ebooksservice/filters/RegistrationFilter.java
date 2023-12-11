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
import static by.intereson.ebooksservice.utils.Constants.*;

@WebFilter(urlPatterns = USERS_CREATE_URL)
public class RegistrationFilter extends HttpFilter {
    private final UserService userService = getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {


        if (!userService.checkUserData(req)) {
            req.getRequestDispatcher(ERROR_DATA_PAGE).forward(req, res);
        } else {
            User user = userService.getUserForLogin(req);
            User user1 = userService.getUserForEmail(req);
            if (user == null && user1 == null) {
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL_SESSION);
                session.setAttribute(LOGIN, req.getParameter(LOGIN));
                session.setAttribute(PASSWORD, req.getParameter(PASSWORD));
                chain.doFilter(req, res);
            } else {
                req.getRequestDispatcher(ERROR_LOGIN_OR_EMAIL_PAGE).forward(req, res);
            }
        }
    }
}
