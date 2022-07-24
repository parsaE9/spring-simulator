package com.example.springsimulator.service;

import com.example.springsimulator.enumeration.TypeEnum;


public interface IRequestProcessor<T> {

    T process(String pk);

    TypeEnum getRequestType();

}
