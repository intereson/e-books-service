package by.intereson.ebooksservice.services;

import by.intereson.ebooksservice.entities.User;
import by.intereson.ebooksservice.repositories.UserRepository;
import by.intereson.ebooksservice.repositories.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository=new UserRepositoryImpl();
    @Override
    public List<User> readUsers() {
        return userRepository.readUsers();
    }
}
