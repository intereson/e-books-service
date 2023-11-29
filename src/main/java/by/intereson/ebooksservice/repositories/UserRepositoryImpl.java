package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
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
    //Arrays.asList(
        //new User(1L,"Andrey","Torin","torin@gmail.com"),
        //new User(2L,"Artem","Basin","basin@gmail.com")

    @Override
    public List<User> readUsers() {
        return users;
    }

    @Override
    public User createUser(User user) {
        user.setId((long)users.size()+1);
        users.add(user);
        return user;
    }
}
