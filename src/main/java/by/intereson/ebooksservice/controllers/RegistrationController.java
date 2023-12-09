package by.intereson.ebooksservice.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.intereson.ebooksservice.utils.Constants.REGISTRATION_USER_PAGE;

@WebServlet(urlPatterns = "/users/registration")
public  class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setMaxInactiveInterval(86400);
        session.setAttribute("login",req.getParameter("login"));
        req.getRequestDispatcher(REGISTRATION_USER_PAGE).forward(req, resp);
    }


}