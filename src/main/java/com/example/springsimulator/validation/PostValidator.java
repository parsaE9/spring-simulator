package com.example.springsimulator.validation;

import com.example.springsimulator.enumeration.TypeEnum;
import org.springframework.stereotype.Component;


@Component
public class PostValidator extends AValidator {

    @Override
    public boolean checkLength(String pk) {
        return pk.length() == 15;
    }

    @Override
    public TypeEnum getType() {
        return TypeEnum.POST;
    }
}
