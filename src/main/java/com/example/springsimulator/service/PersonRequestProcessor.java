package com.example.springsimulator.service;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.response.PersonResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonRequestProcessor extends ARequestProcessor<PersonResponse> {


    @Value("${person.info.file.address}")
    private String personFileAddress;

    @PostConstruct
    private void postConstruct() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(personFileAddress)));
        List<PersonResponse> personResponseList = objectMapper.readValue(content, new TypeReference<List<PersonResponse>>() {});

        for (PersonResponse personResponse : personResponseList){
            responseMap.put(personResponse.getNationalCode(), personResponse);
        }
    }


    @Override
    public TypeEnum getRequestType() {
        return TypeEnum.PERSON;
    }

}
