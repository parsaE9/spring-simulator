package com.example.springsimulator.factory;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.service.IRequestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class RequestProcessorFactory {

    @Autowired
    private List<IRequestProcessor> processorList;
    private Map<TypeEnum, IRequestProcessor> processorMap = new HashMap<>();


    @PostConstruct
    private void postConstruct(){
        for (IRequestProcessor processor: processorList)
            processorMap.put(processor.getRequestType(), processor);
    }


    public IRequestProcessor getProcessor(TypeEnum type) {
        return processorMap.get(type);
    }


}
