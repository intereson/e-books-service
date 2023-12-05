package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepository userRepository;
    private final List<User> users = new ArrayList<>();

    private UserRepositoryImpl() {
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
    public Optional<User> getUser(String login, String password) {
        return users.stream()
                .filter(user -> Objects.equals(user.getLogin(), login))
                .filter(user -> Objects.equals(user.getPassword(), password))
                .findFirst();

    }
}
