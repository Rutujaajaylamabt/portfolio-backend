package com.portfolio.portfolio_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAdminController {

    @GetMapping("/ping")
    public String ping() {
        return "Admin controller is alive ✅";
    }
}
