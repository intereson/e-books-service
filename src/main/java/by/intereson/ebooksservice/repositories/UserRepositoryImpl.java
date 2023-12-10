package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.ShoppingCart;
import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.enums.UserType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static by.intereson.ebooksservice.utils.Constants.DATE_FORMAT;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepository userRepository;
    private final List<User> users = new ArrayList<>();

    private UserRepositoryImpl() {
        users.add(new User(0,"Ivan","Ivanov","ivanov@gmail.com",UserType.USER,"ivanov","ivanov",new ShoppingCart(),LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT))));
        users.add(new User(1,"Admin","Admin","admin@gmail.com", UserType.ADMIN,"admin","admin", new ShoppingCart(), LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT))));
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }

    @Override
    public List<User> readUsers() {
        return users;
    }

    @Override
    public User createUser(User user) {
        user.setId((long) users.size() + 1);
        users.add(user);
        return user;
    }

    @Override
    public User readUser(long id) {
        List<User> collect = users.stream().filter(user -> user.getId() == id).collect(Collectors.toList());
        return collect.get(0);
    }

    @Override
    public User updateUser(User user, User userNew) {
        userNew.setId(user.getId());
        users.remove(user);
        users.add(userNew);
        return userNew;
    }

    @Override
    public boolean deleteUser(User user) {
        return users.remove(user);
    }

    @Override
    public Optional<User> getUser(String login) {
        return users.stream()
                .filter(user -> Objects.equals(user.getLogin(), login))
                .findFirst();
    }

    @Override
    public boolean checkUser(String login) {
        return users.stream()
                .anyMatch(user -> Objects.equals(user.getLogin(), login));

    }

    @Override
    public Optional<User> getUser(String login, String pass) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .filter(user -> user.getPassword().equals(pass))
                .findFirst();
    }

    @Override
    public Optional<User> getUserForEmail(String mail) {
        return users.stream()
                .filter(user -> Objects.equals(user.getMail(), mail))
                .findFirst();
    }
}
