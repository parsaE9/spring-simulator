package com.example.springsimulator.service;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.factory.RequestProcessorFactory;
import com.example.springsimulator.request.Request;
import com.example.springsimulator.response.Response;
import com.example.springsimulator.validation.IValidator;
import com.example.springsimulator.factory.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RequestService {

    @Autowired
    private RequestProcessorFactory requestProcessorFactory;
    @Autowired
    private ValidatorFactory validatorFactory;


    public Response processRequest(TypeEnum type, Request request) {

        Response response = new Response();

        // validate request
        IValidator validator = validatorFactory.getValidator(type);
        validator.validate(request, response);
        if (!response.getOk())
            return response;


        // request is valid, process it.
        IRequestProcessor processor = requestProcessorFactory.getProcessor(type);

        try {
            Object answer = processor.process(request.getPk());
            response.setAnswer(answer);
            response.setOk(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}