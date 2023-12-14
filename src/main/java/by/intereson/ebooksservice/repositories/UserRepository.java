package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
List<User> readUsers();

    User createUser(User user);

    User readUser(long id);

    User updateUser(User user, User userNew);

    boolean deleteUser(User user);

    Optional<User> getUser(String login);
    boolean checkUser(String login);
    Optional<User> getUser(String login,String pass);

    Optional<User> getUserForEmail(String mail);
}
