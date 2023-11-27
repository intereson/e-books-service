package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
private final List<User> users = new ArrayList<>();
    @Override
    public List<User> readUsers() {
        return users;
    }
}
