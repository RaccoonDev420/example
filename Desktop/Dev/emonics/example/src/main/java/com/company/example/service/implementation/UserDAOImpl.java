package com.company.example.service.implementation;

import com.company.example.model.User;
import com.company.example.repositories.UserRepository;
import com.company.example.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDAOImpl extends GenericDAOImpl<User, UserRepository> implements UserDAO {

    @Autowired
    public UserDAOImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
