package com.kiranastore.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.kiranastore.entity.User} entity
 */
@Data
public class UserDto1{
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Long mobileNo;
}