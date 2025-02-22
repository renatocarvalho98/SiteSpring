package com.eazybytes.eazyschool.service;

import com.eazybytes.eazyschool.model.ContactMessage;
import com.eazybytes.eazyschool.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    @Autowired
    private ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public void saveMessage(ContactMessage message) {
        System.out.println("Saving Message: " + message);
        contactMessageRepository.save(message);
        System.out.println("Message saved successfully in DB!");;
    }
}