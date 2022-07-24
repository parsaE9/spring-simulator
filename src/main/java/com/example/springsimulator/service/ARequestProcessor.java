package com.example.springsimulator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;


public abstract class ARequestProcessor<T> implements IRequestProcessor<T> {

    protected Map<String, T> responseMap = new HashMap<>();
    protected static ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public T process(String pk) {
        if (responseMap.containsKey(pk)) {
            return responseMap.get(pk);
        }
        return null;
    }

}
