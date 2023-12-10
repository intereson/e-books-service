package by.intereson.ebooksservice.controllers.registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.intereson.ebooksservice.utils.Constants.*;

@WebServlet(urlPatterns = USERS_REGISTRATION_URL)
public  class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL_SESSION);
        session.setAttribute(LOGIN,req.getParameter(LOGIN));
        req.getRequestDispatcher(USERS_REGISTRATION_PAGE).forward(req, resp);
    }


}