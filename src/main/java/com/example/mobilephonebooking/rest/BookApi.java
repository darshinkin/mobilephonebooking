package com.example.mobilephonebooking.rest;

import com.example.mobilephonebooking.model.Phone;
import com.example.mobilephonebooking.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookApi {

    private final BookService bookService;

    @GetMapping(value = "${app.endpoint.phone.booking}")
    public ResponseEntity<Phone> bookPhone(@PathVariable long phoneId, @PathVariable String person) {
        Optional<Phone> book = bookService.book(phoneId, person);
        if (book.isPresent()) {
            Phone phone = book.get();
            return ResponseEntity.ok(phone);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "${app.endpoint.phone.return}")
    public ResponseEntity<String> returnPhone(@PathVariable int phoneId) {
        bookService.returnPhone(phoneId);
        return ResponseEntity.ok("Good luck");
    }

}
