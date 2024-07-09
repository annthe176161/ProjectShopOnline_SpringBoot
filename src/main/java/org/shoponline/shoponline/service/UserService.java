package org.shoponline.shoponline.service;

import org.shoponline.shoponline.model.User;
import org.shoponline.shoponline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}