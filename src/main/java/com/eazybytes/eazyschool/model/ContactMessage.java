package com.eazybytes.eazyschool.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contact_messages")
public class ContactMessage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String message;
    private LocalDateTime createdDate = LocalDateTime.now();

    //Constructor
    public ContactMessage() {
    }

    public ContactMessage(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }




}
