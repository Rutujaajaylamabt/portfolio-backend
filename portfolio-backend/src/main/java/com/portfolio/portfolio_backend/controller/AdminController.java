package com.portfolio.portfolio_backend.controller;

import com.portfolio.portfolio_backend.entity.Contact;
import com.portfolio.portfolio_backend.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    private final ContactService contactService;

    // constructor injection
    public AdminController(ContactService contactService) {
        this.contactService = contactService;
    }

    private final String ADMIN_EMAIL = "admin@gmail.com";
    private final String ADMIN_PASSWORD = "admin123";

    // ✅ ADMIN LOGIN
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
        Map<String, Object> response = new HashMap<>();

        String email = data.get("email");
        String password = data.get("password");

        if (ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
            response.put("success", true);
            response.put("message", "Login successful");
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
        }
        return response;
    }

    // ✅ VIEW ALL CONTACT MESSAGES (IMPORTANT)
    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAll();
    }
}
