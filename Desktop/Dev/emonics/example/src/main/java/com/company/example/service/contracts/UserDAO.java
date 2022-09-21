package com.company.example.service.contracts;

import com.company.example.model.User;

import java.util.Optional;

public interface UserDAO extends GenericDAO<User> {
    Optional<User> findByEmail(String email);
}
