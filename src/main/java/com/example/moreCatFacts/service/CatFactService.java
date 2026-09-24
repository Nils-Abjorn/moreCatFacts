package com.example.moreCatFacts.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moreCatFacts.dto.CatFactResponse;
import com.example.moreCatFacts.exception.TPotException;

@Service
public class CatFactService {

    private final RestTemplate restTemplate;

    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getFact(boolean htmlErrResponse) {
        CatFactResponse response = restTemplate.getForObject("https://catfact.ninja/fact", CatFactResponse.class);
        if (response != null) {
            if (response.getFact().startsWith("T"))
                throw new TPotException(htmlErrResponse);
            return response.getFact();
        }
        return null;
    }
}