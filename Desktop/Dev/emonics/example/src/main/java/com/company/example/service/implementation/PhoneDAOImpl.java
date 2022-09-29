package com.company.example.service.implementation;

import com.company.example.model.Phone;
import com.company.example.repositories.PhoneRepository;
import com.company.example.service.contracts.PhoneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneDAOImpl extends GenericDAOImpl<Phone, PhoneRepository> implements PhoneDAO {
    @Autowired
    public PhoneDAOImpl(PhoneRepository repository) {
        super(repository);

    }

    @Override
    public Iterable<Phone> findByBrand(String brand) {
        return repository.findByBrand(brand);
    }
}
