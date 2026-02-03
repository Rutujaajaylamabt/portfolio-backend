package com.portfolio.portfolio_backend.controller;

import com.portfolio.portfolio_backend.entity.Contact;
import com.portfolio.portfolio_backend.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // ✅ THIS WAS MISSING
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return service.save(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return service.getAll();
    }
}
