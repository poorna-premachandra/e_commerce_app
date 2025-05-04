package com.e_commerce_app.backend.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
