package com.example.mobilephonebooking.services;

import com.example.mobilephonebooking.model.Phone;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
public class BookService {

    private List<Phone> phones = new CopyOnWriteArrayList<>();
}
