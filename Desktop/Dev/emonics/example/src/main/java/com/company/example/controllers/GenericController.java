package com.company.example.controllers;

import com.company.example.service.contracts.GenericDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController <E, S extends GenericDAO<E>> {

    protected final S service;
    protected String entitie;

    public GenericController(S service) {
        this.service = service;
    }

    //GetAll
    @GetMapping
    public ResponseEntity<?> findAll(){
        Map<String, Object> message = new HashMap<>();
        List<E> result = (List<E>) service.findAll();
        if (result.isEmpty()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("No existen %ss", entitie));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("success", Boolean.TRUE);
        message.put(entitie+"s", result);

        return ResponseEntity.ok(message);
    }

    //FindByID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id){
        Map<String, Object> message = new HashMap<>();
        Optional<E> result = service.findById(id);
        if (!result.isPresent()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("No existen %ss", entitie));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("success", Boolean.TRUE);
        message.put("datos", result);

        return ResponseEntity.ok(message);
    }

    //Save
    @PostMapping
    public ResponseEntity<?> saveEntitie(@RequestBody E object){
        Map<String, Object> message = new HashMap<>();
        message.put("success", Boolean.TRUE);
        message.put("datos", service.save(object));

        return ResponseEntity.ok(message);
    }


    //Delete
    @DeleteMapping("/{id}")
    public void deleteEntitie(@PathVariable("id")long id){
        service.deleteById(id);
    }


}

