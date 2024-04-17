package edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.impl;


import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.model.User;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.repository.UserRepository;
import edu.miu.cs489appsd.lab6.AdventisDentistsSystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElse(null);
    }

    @Override
    public User registerNewUser(User user) {
        return userRepository.save(user);
    }
}