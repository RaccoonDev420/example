package com.company.example.controllers;

import com.company.example.model.User;
import com.company.example.service.contracts.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController extends GenericController<User, UserDAO>{
    @Autowired
    public UserController(UserDAO service) {
        super(service);
        entitie = "User";
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id, @RequestBody User user){
        Map<String, Object> message = new HashMap<>();
        Optional<User> result = service.findById(id);
        if (!result.isPresent()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("%s with  does not exist", entitie));
            return ResponseEntity.badRequest().body(message);
        }
        result.get().setName(user.getName());
        result.get().setPassword(user.getPassword());
        service.save(result.get());
        message.put("success", Boolean.TRUE);
        message.put("datos", result);

        return ResponseEntity.ok(message);
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByEmail(@RequestParam(name = "email") String email){
        Map<String, Object> message = new HashMap<>();
        Optional<User> result = service.findByEmail(email);
        if (!result.isPresent()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("%s with email %s does not exist", entitie, email));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("success", Boolean.TRUE);
        message.put("datos", result);

        return ResponseEntity.ok(message);
    }
}
