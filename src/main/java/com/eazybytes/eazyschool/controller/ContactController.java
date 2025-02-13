package com.eazybytes.eazyschool.controller;


import com.eazybytes.eazyschool.model.ContactMessage;
import com.eazybytes.eazyschool.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "")

public class ContactController {

    @Autowired
    private ContactMessageService contactMessageService;

    @PostMapping("/submit")
    public String saveContactMessage(@RequestBody ContactMessage contactMessage) {
        contactMessageService.saveMessage(contactMessage);
        return "success";
    }
}
