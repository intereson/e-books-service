package by.intereson.ebooksservice.mappers;

import by.intereson.ebooksservice.entities.ShoppingCart;
import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.entities.UserType;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.intereson.ebooksservice.utils.Constants.*;

public class UserMapper {
    public static final UserMapper userMapper=getInstance();
    public User buildUser(HttpServletRequest request) {
        return User.builder()
                .name(request.getParameter(NAME_USER))
                .surname(request.getParameter(SURNAME_USER))
                .mail(request.getParameter(MAIL_USER))
                .userType(UserType.valueOf(UserType.USER.name()))
                .login(request.getParameter(LOGIN))
                .password(request.getParameter(PASSWORD))
                .shoppingCart(new ShoppingCart())
                .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.uu HH-mm")))
                .build();
    }
    public static UserMapper getInstance(){
        if(userMapper==null){
            return new UserMapper();
        }
        return userMapper;
    }
}
