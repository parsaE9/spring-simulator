package com.example.springsimulator.service;

import com.example.springsimulator.enumeration.TypeEnum;
import com.example.springsimulator.response.PostResponse;
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
public class PostRequestProcessor extends ARequestProcessor<PostResponse> {


    @Value("${post.info.file.address}")
    private String postFileAddress;

    @PostConstruct
    private void postConstruct() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(postFileAddress)));
        List<PostResponse> postResponseList = objectMapper.readValue(content, new TypeReference<List<PostResponse>>() {});

        for (PostResponse postResponse : postResponseList){
            responseMap.put(postResponse.getPostalCode(), postResponse);
        }
    }


    @Override
    public TypeEnum getRequestType() {return TypeEnum.POST;}

}