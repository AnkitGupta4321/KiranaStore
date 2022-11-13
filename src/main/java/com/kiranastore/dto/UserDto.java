package com.kiranastore.dto;

import com.kiranastore.entity.UserType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.kiranastore.entity.User} entity
 */
@Data
public class UserDto{
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Long mobileNo;
    private final LocalDateTime creationDate;
    private final LocalDateTime lastUpdateDate;
    private final UserType userType;
    private final String password;
}