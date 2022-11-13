package com.kiranastore.controller;


import com.kiranastore.dto.UserDto;
import com.kiranastore.dto.UserDto1;
import com.kiranastore.entity.User;
import com.kiranastore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserDto user){
        User user1 = modelMapper.map(user, User.class);
        try {
            User user2 = userService.createUser(user1);
            return new ResponseEntity(modelMapper.map(user2, UserDto1.class), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity("User not Added", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{email}")
    public ResponseEntity updateUser(@PathVariable(name = "email") String email,@RequestBody UserDto1 user){
        User user1 = modelMapper.map(user, User.class);
        try {
            User user2 = userService.updateUser(email, user1);
            return new ResponseEntity(modelMapper.map(user2, UserDto1.class), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Update Failed", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity getUserById(@PathVariable(name = "email") String email){
        try {
            User user = userService.getUser(email);
            return new ResponseEntity<>(modelMapper.map(user, UserDto1.class), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/")
    public ResponseEntity updatePassword(@RequestParam(name = "eamil") String email,@RequestBody String password){
        try {
            userService.updatePassword(email, password);
            return new ResponseEntity<>("Password Update", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Password Not Updated", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity deleteUser(@PathVariable(name = "email") String email){
        try{
            userService.deleteUser(email);
            return new ResponseEntity<>(email + "is deleted", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

}
