package com.company.example.service.specifications.builders;

import com.company.example.model.Phone;
import com.company.example.service.specifications.PhoneSpecification;
import com.company.example.service.specifications.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneSpecificationBuilder {
    private final List<SearchCriteria> params;


    public PhoneSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public PhoneSpecificationBuilder with(String key, String operation, Object value, String isOr){
        params.add(new SearchCriteria(key,operation,value));
        return this;
    }

    public Specification<Phone> build(){
        if(params.size() == 0){
            return null;
        }

        List<Specification> specs = params.stream().map(PhoneSpecification::new).collect(Collectors.toList());
        Specification result = specs.get(0);

        for(int i=0; i< params.size();i++){
            result = Specification.where(result)
                    .and(specs.get(i));
        }
        return result;

    }
}
