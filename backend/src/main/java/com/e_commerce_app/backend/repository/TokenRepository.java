package com.e_commerce_app.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce_app.backend.model.Token;

import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {

    Optional<Token> findByToken(String token);

    boolean existsByToken(String token);
}
