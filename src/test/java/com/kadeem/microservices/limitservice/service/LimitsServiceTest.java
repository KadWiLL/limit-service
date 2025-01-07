package com.kadeem.microservices.limitservice.service;

import com.kadeem.microservices.limitservice.bean.Limits;
import com.kadeem.microservices.limitservice.configuration.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LimitsServiceTest {

    @Mock
    private Configuration configuration;

    @InjectMocks
    private LimitsService limitsService;

    @Test
    void testGetLimits() {
        // Arrange
        when(configuration.getMinimum()).thenReturn(1);
        when(configuration.getMaximum()).thenReturn(100);

        // Act
        Limits limits = limitsService.getLimits();

        // Assert
        assertEquals(1, limits.getMinimum());
        assertEquals(100, limits.getMaximum());
    }
}
