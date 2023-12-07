package by.intereson.ebooksservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder
public class User {
    private long id;
    private String name;
    private String surname;
    private String mail;
    private UserType userType;
    private String login;
    private String password;
    private ShoppingCart shoppingCart;
    private String dateTime;
}
