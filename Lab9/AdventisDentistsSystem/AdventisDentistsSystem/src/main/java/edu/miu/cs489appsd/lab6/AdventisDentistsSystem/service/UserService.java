package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service;

import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.User;

public interface UserService {

    User getUserByUsername(String username);

    User registerNewUser(User user);
}
