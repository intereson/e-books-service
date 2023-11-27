package by.intereson.ebooksservice.repositories;

import by.intereson.ebooksservice.entities.User;

import java.util.List;

public interface UserRepository {
List<User> readUsers();
}
