package com.mderyol.demo.circuitbreaker.controller;

import com.mderyol.demo.circuitbreaker.service.ExternalService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
@AllArgsConstructor
public class Controller {
    private final ExternalService externalService;

    @GetMapping("/call-service")
    @CircuitBreaker(name = "myService")
    public String callService() {
        return externalService.call();
    }
}
