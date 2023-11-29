package by.intereson.ebooksservice.mappers;

import by.intereson.ebooksservice.entities.User;

import javax.servlet.http.HttpServletRequest;

import static by.intereson.ebooksservice.utils.Constants.*;

public class UserMapper {
    public User buildUser(HttpServletRequest request) {
        return User.builder()
                .name(request.getParameter(NAME_USER))
                .surname(request.getParameter(SURNAME_USER))
                .mail(request.getParameter(MAIL_USER))
                .build();
    }
}
