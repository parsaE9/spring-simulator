package com.example.springsimulator.factory;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.validation.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ValidatorFactory {

    @Autowired
    private List<IValidator> validatorList;
    private Map<TypeEnum, IValidator> validatorMap = new HashMap<>();


    @PostConstruct
    private void postConstruct() {
        for (IValidator validator: validatorList)
            validatorMap.put(validator.getType(), validator);
    }


    public IValidator getValidator(TypeEnum type) {
        return validatorMap.get(type);
    }


}