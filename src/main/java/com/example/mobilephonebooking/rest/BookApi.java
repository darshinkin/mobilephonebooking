package com.example.mobilephonebooking.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookApi {

    @GetMapping("/book")
    public ResponseEntity<String> bookPhone() {
        return ResponseEntity.ok("Booked phone.");
    }

    @GetMapping("/return")
    public ResponseEntity<String> returnPhone() {
        return ResponseEntity.ok("Returned phone.");
    }

}
