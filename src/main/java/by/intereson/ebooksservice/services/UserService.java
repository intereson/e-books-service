package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.User;

import java.util.List;

public interface UserService {
    List<User> readUsers();
    User createUser(User user);

    User readUser(long id);

    User updateUser(User user, User userNew);

    boolean deleteUser(User user);
}
