package com.example.mobilephonebooking.services;

import com.example.mobilephonebooking.model.Phone;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface BookingPhone {
    Optional<Phone> book(int id);
}
