package com.company.example.service.contracts;

import com.company.example.model.Phone;

public interface PhoneDAO extends GenericDAO<Phone>{
    Iterable<Phone> findByBrand(String brand);
    Iterable<Phone> findAll(String filters, String specification);
}

