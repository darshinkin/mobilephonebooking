package com.example.mobilephonebooking.services;

import com.example.mobilephonebooking.model.Phone;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class BookService implements BookingPhone, ReturnPhone {

    private List<Phone> phones = new CopyOnWriteArrayList<>();

    @Override
    public Phone book(int id) {
        return null;
    }

    @Override
    public Phone returnPhone(int id) {
        return null;
    }
}
