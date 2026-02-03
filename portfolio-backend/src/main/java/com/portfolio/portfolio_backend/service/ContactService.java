package com.portfolio.portfolio_backend.service;

import com.portfolio.portfolio_backend.entity.Contact;
import com.portfolio.portfolio_backend.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repo;

    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    // SAVE CONTACT
    public Contact save(Contact contact) {
        return repo.save(contact);
    }

    // ✅ GET ALL CONTACTS (RENAMED METHOD)
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }

    public List<Contact> getAll() {
        return repo.findAll();
    }
}
