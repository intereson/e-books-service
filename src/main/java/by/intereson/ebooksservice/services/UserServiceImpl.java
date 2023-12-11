package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.repositories.UserRepository;
import by.intereson.ebooksservice.repositories.UserRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static by.intereson.ebooksservice.utils.Constants.*;

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
    public User getUserForLogin(HttpServletRequest req) {
        Optional<User> user = userRepository.getUser(req.getParameter(LOGIN));
        return user.orElse(null);
    }

    @Override
    public boolean checkUserLoginAndPass(String login, String pass) {
        return userRepository.getUser(login, pass).isPresent();
    }

    @Override
    public boolean checkUserData(HttpServletRequest request) {
        return (!request.getParameter(NAME_USER).isEmpty())
                && (!request.getParameter(SURNAME_USER).isEmpty()) && (!request.getParameter(MAIL_USER).isEmpty()) &&
                (!request.getParameter(LOGIN).isEmpty()) && (!request.getParameter(PASSWORD).isEmpty());
    }

    @Override
    public User getUserForEmail(HttpServletRequest req) {
        Optional<User> user = userRepository.getUserForEmail(req.getParameter(MAIL_USER));
        return user.orElse(null);
    }

    @Override
    public List<User> getUser(long id) {
        return readUsers().stream()
                .filter(user -> user.getId() ==id)
                .collect(Collectors.toList());
    }


    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
