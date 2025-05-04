package com.e_commerce_app.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tokens")
@NoArgsConstructor
@AllArgsConstructor
public class Token {
    @Id
    private String id;
    private String token;
    private String userId;
    private Date expiryDate;
}
