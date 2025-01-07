package com.kadeem.microservices.limitservice.controller;

import com.kadeem.microservices.limitservice.bean.Limits;
import com.kadeem.microservices.limitservice.configuration.Configuration;
import com.kadeem.microservices.limitservice.service.LimitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsController {

    private final LimitsService limitsService;

    @GetMapping("/limits")
    public Limits getLimits(){
        return limitsService.getLimits();
        //return new Limits(1,100);
    }
}
