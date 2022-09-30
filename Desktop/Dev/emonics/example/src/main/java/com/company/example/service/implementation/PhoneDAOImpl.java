package com.company.example.service.implementation;

import com.company.example.model.Phone;
import com.company.example.repositories.PhoneRepository;
import com.company.example.service.contracts.PhoneDAO;
import com.company.example.service.specifications.builders.FilterBuilder;
import com.company.example.service.specifications.builders.PhoneSpecificationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public Iterable<Phone> findAll(String filters, String specification) {
        FilterBuilder builder = new FilterBuilder();
        PhoneSpecificationBuilder phoneSpecificationBuilder = new PhoneSpecificationBuilder();
        String regex = "(\\w+?)(:|<|>)(\\w+?),";
        String key = null;
        String operation = null;
        String value = null;
        String isOr = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(filters + ",");

        while (matcher.find()) {

            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        var split = specification.split(",");
        for(int i=0; i< split.length; i++){

            if(split[i].contains("-")){
                //System.out.println(split[i]);
                regex = "(\\w+?)(-)(\\w+?)(:|<|>)(\\w+?)(%|&)";
                pattern = Pattern.compile(regex);
                Matcher matcher1 = pattern.matcher(split[i]);
                while (matcher1.find()){
                    key = matcher1.group(1)+matcher1.group(2)+matcher1.group(3);
                    operation = matcher1.group(4);
                    value = matcher1.group(5);
                    isOr = matcher1.group(6);
                    phoneSpecificationBuilder.with(key,operation,value,isOr);
                    //System.out.println(value+isOr);

                }
            }else {
                //System.out.println(split[i]);
                regex = "(\\w+?)(:|<|>)(\\w+?)(%|&)";
                pattern = Pattern.compile(regex);
                Matcher matcher1 = pattern.matcher(split[i]);
                while (matcher1.find()) {
                    key = matcher1.group(1);
                    operation = matcher1.group(2);
                    value = matcher1.group(3);
                    isOr = matcher1.group(4);
                    phoneSpecificationBuilder.with(key,operation,value,isOr);
                    System.out.println(isOr);

                    //System.out.println(isOr+key+operation+value);
                }
            }



        }


        List<Sort.Order> orders = builder.build();
        Specification<Phone> specs = phoneSpecificationBuilder.build();
        Iterable<Phone> result = repository.findAll(specs,Sort.by(orders));

        ArrayList<Phone> resultTest = (ArrayList<Phone>) result;
        if(resultTest.isEmpty()){
            return null;
        }
        return result;
    }
}
