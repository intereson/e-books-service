package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    List<User> readUsers();
    User createUser(User user);

    User readUser(long id);

    User updateUser(User user, User userNew);

    boolean deleteUser(User user);

   User getUserForLogin(HttpServletRequest req);
    boolean checkUserLoginAndPass(String login, String pass);
    boolean checkUserData(HttpServletRequest request);

    User getUserForEmail(HttpServletRequest req);
    List<User> getUser(long id);

}
