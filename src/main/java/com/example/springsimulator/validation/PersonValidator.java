package com.example.springsimulator.validation;

import com.example.springsimulator.enumeration.TypeEnum;
import org.springframework.stereotype.Component;


@Component
public class PersonValidator extends AValidator {

    @Override
    public boolean checkLength(String pk) {
        return pk.length() == 10;
    }

    @Override
    public TypeEnum getType() {
        return TypeEnum.PERSON;
    }
}
