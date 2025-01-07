package com.kadeem.microservices.limitservice.service;

import com.kadeem.microservices.limitservice.bean.Limits;
import com.kadeem.microservices.limitservice.configuration.Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LimitsService {

    private final Configuration configuration;

    public Limits getLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
