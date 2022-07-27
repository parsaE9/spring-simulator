package com.example.springsimulator.controller;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.dto.request.Request;
import com.example.springsimulator.dto.response.Response;
import com.example.springsimulator.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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