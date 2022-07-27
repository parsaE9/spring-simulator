package com.example.springsimulator.validation;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.dto.request.Request;
import com.example.springsimulator.dto.response.Response;

public interface IValidator {

    public void validate(Request request, Response response);

    public boolean checkLength(String pk);

    public TypeEnum getType();

}
