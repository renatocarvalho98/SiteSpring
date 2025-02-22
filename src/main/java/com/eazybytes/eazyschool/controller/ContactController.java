package com.eazybytes.eazyschool.controller;


import com.eazybytes.eazyschool.model.ContactMessage;
import com.eazybytes.eazyschool.service.ContactMessageService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Slf4j
@Controller
public class ContactController {

   private final ContactMessageService contactMessageService;


    @Autowired
    private ContactController (ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    };


    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new ContactMessage());
        return "contact.html";
    }


    @RequestMapping(value = "/saveMessage",method = POST)
    public String saveMessage( @Valid @ModelAttribute("contact") ContactMessage contact,
                              Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact";  // V
        }

        contactMessageService.saveMessage(contact);
        System.out.println("Message saved successfully in DB!");
        return "redirect:/contact";
    }



}
