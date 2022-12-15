package com.example.demo.controller;

import com.example.demo.AvailabilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/availability")
public class ClientController {

    private final AvailabilityService availabilityService;

    public ClientController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    @GetMapping
    public Mono<String> getMessage(
            @RequestParam(value = "lang", required = false, defaultValue = "") String lang,
            @RequestParam(value = "time", required = false, defaultValue = "") String time
    ) {
        return availabilityService.getAvailabilityMessage(lang, time);
    }

}
