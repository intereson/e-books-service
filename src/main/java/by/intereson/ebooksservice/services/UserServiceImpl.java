package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.repositories.UserRepository;
import by.intereson.ebooksservice.repositories.UserRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static UserService userService;
    private final UserRepository userRepository = UserRepositoryImpl.getInstance();

    private UserServiceImpl() {

    }

    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();
    }

    @Override
    public User createUser(User user) {
        userRepository.createUser(user);
        return user;
    }

    @Override
    public User readUser(long id) {
        return userRepository.readUser(id);
    }

    @Override
    public User updateUser(User user, User userNew) {
        return userRepository.updateUser(user, userNew);
    }

    @Override
    public boolean deleteUser(User user) {
        return userRepository.deleteUser(user);
    }

    @Override
    public boolean checkUser(HttpServletRequest req) {
        Optional<User> user = userRepository.getUser(req.getParameter("login"), req.getParameter("password"));
        return user.isPresent();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
