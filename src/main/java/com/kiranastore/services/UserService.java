package com.kiranastore.services;


import com.kiranastore.dto.UserDto;
import com.kiranastore.dto.UserDto1;
import com.kiranastore.entity.User;

public interface UserService {

    User createUser(User user);
    User updateUser(String email,User user);
    String deleteUser(String email);
    String updatePassword(String email, String password);

    User getUser(String email);
}
