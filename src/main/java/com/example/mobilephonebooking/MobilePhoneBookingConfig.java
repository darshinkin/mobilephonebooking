package com.example.mobilephonebooking;

import com.example.mobilephonebooking.model.Phone;
import com.example.mobilephonebooking.services.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class MobilePhoneBookingConfig {

    private AtomicInteger count = new AtomicInteger(0);

    @Bean
    BookService bookService() {
        BookService bookService = new BookService();
        initBookService(bookService);
        return bookService;
    }

    private void initBookService(BookService bookService) {
        List<Phone> phones = new ArrayList<>(10);
        phoneModels.forEach(model -> phones.add(Phone.builder().id(count.addAndGet(1)).availability(true).model(model).build()));
        bookService.setPhones(phones);
    }

    @Value("#{'${app.phones}'.split(',')}")
    private List<String> phoneModels;
}
