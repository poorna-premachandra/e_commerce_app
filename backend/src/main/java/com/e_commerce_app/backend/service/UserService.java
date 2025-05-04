package com.e_commerce_app.backend.service;

import org.springframework.stereotype.Service;

import com.e_commerce_app.backend.model.User;
import com.e_commerce_app.backend.repository.UserRepository;
import com.e_commerce_app.backend.dto.UserSignupDTO;
import com.e_commerce_app.backend.dto.UserLoginDTO;
import com.e_commerce_app.backend.model.model_enum.Role;
import com.e_commerce_app.backend.util.JwtUtil;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseGet(null);
    }

    public void signup(UserSignupDTO userSignupDTO) {
        User user = new User();
        user.setEmail(userSignupDTO.getEmail());
        user.setPassword(userSignupDTO.getPassword());
        user.setFirstName(userSignupDTO.getFirstName());
        user.setLastName(userSignupDTO.getLastName());
        user.setRoles(List.of(Role.USER_BUYER)); // Default role of an user
        userRepository.save(user);
    }

    public String login(UserLoginDTO userLoginDTO) {
        User user = getUserByEmail(userLoginDTO.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        if (!user.getPassword().equals(userLoginDTO.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token = jwtUtil.generateToken(user.getEmail());
        return token;
    }
}
