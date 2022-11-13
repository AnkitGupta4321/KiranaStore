package com.kiranastore.services;

import com.kiranastore.dao.UserRepository;
import com.kiranastore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User createUser(User user) {
        user.setCreationDate(LocalDateTime.now());
        user.setLastUpdateDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String email, User user) {
            User user1 = userRepository.findByEmail(email);

            if(user.getFirstName() != null) user1.setFirstName(user.getFirstName());
            if(user.getLastName() != null) user1.setLastName(user.getLastName());
            if(user.getEmail() != null) user1.setEmail(user.getEmail());
            if(user.getMobileNo() != null) user1.setMobileNo(user.getMobileNo());
            user1.setLastUpdateDate(LocalDateTime.now());
            return userRepository.save(user);

    }

    @Override
    public String deleteUser(String email) {
         userRepository.deleteUserByEmail(email);
        return "User deleted";
    }

    @Override
    public String updatePassword(String email, String password) {

           User user1 = userRepository.findByEmail(email);
           user1.setPassword(password);
           user1.setLastUpdateDate(LocalDateTime.now());
           userRepository.save(user1);
           return "User Saved Successfully";
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }
}
