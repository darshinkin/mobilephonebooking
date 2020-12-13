package com.example.mobilephonebooking.services;

import com.example.mobilephonebooking.model.Phone;

import java.util.Optional;

public interface BookingPhone {
    Optional<Phone> book(long id);
}
