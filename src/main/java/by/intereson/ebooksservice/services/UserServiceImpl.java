package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.repositories.UserRepository;
import by.intereson.ebooksservice.repositories.UserRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static by.intereson.ebooksservice.utils.Constants.ERROR_DATA_PAGE;

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
        Optional<User> user = userRepository.getUser(req.getParameter("login"));
        return user.orElse(null);
    }

    @Override
    public boolean checkUserLoginAndPass(String login, String pass) {
        return  userRepository.getUser(login, pass).isPresent();



    }

    @Override
    public boolean checkUserData(HttpServletRequest request) {
        return (!request.getParameter("name").isEmpty())
                && (!request.getParameter("surname").isEmpty()) && (!request.getParameter("mail").isEmpty()) &&
                (!request.getParameter("login").isEmpty()) && (!request.getParameter("password").isEmpty());
    }

    @Override
    public User getUserForEmail(HttpServletRequest req) {
        Optional<User> user = userRepository.getUserForEmail(req.getParameter("mail"));
        return user.orElse(null);
    }


    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
}
