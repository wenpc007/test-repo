package com.wenpc.unittest.tddlab.labTdd.controller;

import com.wenpc.unittest.tddlab.labTdd.service.ICharsLayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharsLayController {

    @Autowired
    private ICharsLayService charsLayOutService;

    @GetMapping("/charsLay")
    public List<String> charsLay(String input){
        return charsLayOutService.lay(input);
    }
}
