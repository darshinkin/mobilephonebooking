package com.example.mobilephonebooking.rest;

import com.example.mobilephonebooking.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookApi {

    private final BookService bookService;

    @GetMapping(value = "${app.endpoint.phone.booking}")
    public ResponseEntity<String> bookPhone(@PathVariable int phoneId) {
        bookService.book(phoneId);
        return ResponseEntity.ok("Booked phone.");
    }

    @GetMapping(value = "${app.endpoint.phone.return}")
    public ResponseEntity<String> returnPhone(@PathVariable int phoneId) {
        bookService.book(phoneId);
        return ResponseEntity.ok("Returned phone.");
    }

}