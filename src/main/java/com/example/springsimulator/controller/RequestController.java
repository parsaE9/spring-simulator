package com.example.springsimulator.controller;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.factory.RequestProcessorFactory;
import com.example.springsimulator.request.Request;
import com.example.springsimulator.response.Response;
import com.example.springsimulator.service.IRequestProcessor;
import com.example.springsimulator.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;


@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;


    @PostMapping("/person")
    public Response person(@RequestBody Request request) {
        return requestService.processRequest(TypeEnum.PERSON, request);
    }


    @PostMapping("/post")
    public Response post(@RequestBody Request request) {
        return requestService.processRequest(TypeEnum.POST, request);
    }


}