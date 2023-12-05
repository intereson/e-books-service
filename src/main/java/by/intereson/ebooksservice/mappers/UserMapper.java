package by.intereson.ebooksservice.mappers;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.utils.Access;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.intereson.ebooksservice.utils.Constants.*;

public class UserMapper {
    public User buildUser(HttpServletRequest request) {
        return User.builder()
                .name(request.getParameter(NAME_USER))
                .surname(request.getParameter(SURNAME_USER))
                .mail(request.getParameter(MAIL_USER))
                .access(Access.USER.name())
                .login(request.getParameter(LOGIN))
                .password(request.getParameter(PASSWORD))
                .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.uu HH-mm")))
                .build();
    }
}
