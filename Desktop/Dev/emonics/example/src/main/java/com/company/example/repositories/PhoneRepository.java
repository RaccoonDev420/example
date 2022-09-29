package com.company.example.repositories;

import com.company.example.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {
    Iterable<Phone> findByBrand(String brand);
}
