package com.kiranastore.services;


import com.kiranastore.dto.UserDto;
import com.kiranastore.dto.UserDto1;
import com.kiranastore.entity.User;

public interface UserService {

    User createUser(User user);
    User updateUser(Long id,User user);
    String deleteUser(Long id);
    String updatePassword(Long id, String password);
}
