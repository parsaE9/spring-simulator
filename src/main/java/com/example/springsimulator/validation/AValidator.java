package com.example.springsimulator.validation;

import com.example.springsimulator.dto.request.Request;
import com.example.springsimulator.dto.response.Response;


public abstract class AValidator implements IValidator {

    @Override
    public void validate(Request request, Response response){

        String pk = request.getPk().trim();

        if (pk.isEmpty()){
            response.setError("PK is empty!");
        }
        else if (!pk.matches("[0-9]+")) {
            response.setError("PK must only contain digits!");
        }
        else if (!checkLength(pk)) {
            response.setError("pk must have appropriate length!");
        }
        else {
            response.setOk(true);
        }

    }

}