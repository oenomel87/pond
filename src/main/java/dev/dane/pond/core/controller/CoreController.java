package dev.dane.pond.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {

    @GetMapping("/beat")
    public String healthCheck() {
        return "OK";
    }
}
