package com.mderyol.demo.circuitbreaker.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExternalService {
    private final Random random = new Random();

    public String call() {
        if (random.nextInt(100) < 70) {
            throw new RuntimeException("Service failed");
        }
        return "Service response";
    }
}
