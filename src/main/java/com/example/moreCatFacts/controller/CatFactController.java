package com.example.moreCatFacts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.moreCatFacts.service.*;;

@RestController
public class CatFactController {

    private final CatFactService catFactService;

    public CatFactController(CatFactService catFactService) {
        this.catFactService = catFactService;
    }

    @GetMapping("/catfact")
    public String getCatFact(@RequestParam(value = "htmlErrResponse", defaultValue = "false") boolean htmlErrResponse) {
        return catFactService.getFact(htmlErrResponse);
    }
}