package edu.cs489.adssystem.service;

import edu.cs489.adssystem.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer userId);

    User updateUser(User user);

    void deleteUserById(Integer userId);
}
