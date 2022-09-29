package com.company.example.controllers;

import com.company.example.model.Phone;
import com.company.example.model.User;
import com.company.example.service.contracts.PhoneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/phones")
public class PhoneController extends GenericController<Phone, PhoneDAO>{
    @Autowired
    public PhoneController(PhoneDAO service) {
        super(service);
        entitie = "Phone";
    }

    @GetMapping("/brand")
    public ResponseEntity<?> findByBrand(@RequestParam(name = "brand") String brand){
        Map<String, Object> message = new HashMap<>();
        List<Phone> result = (List<Phone>) service.findByBrand(brand);
        if (result.isEmpty()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("%s with brand %s does not exist", entitie, brand));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("success", Boolean.TRUE);
        message.put("datos", result);

        return ResponseEntity.ok(message);
    }
}
