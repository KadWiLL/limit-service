package com.kadeem.microservices.limitservice.configuration;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
//@ConfigurationProperties("limit-service")
public class Configuration {

    @Value("${limit-service.minimum}")
    private int minimum;

    @Value("${limit-service.maximum}")
    private int maximum;
}
