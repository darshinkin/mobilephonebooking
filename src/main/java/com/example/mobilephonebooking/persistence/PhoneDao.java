package com.example.mobilephonebooking.persistence;

import com.example.mobilephonebooking.model.Phone;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
public class PhoneDao {

    private final PhoneRepository phoneRepository;

    @Transactional
    public Optional<Phone> retreivePhoneById(long id, String person) {
        Optional<Phone> phone = phoneRepository.findById(id);
        phoneRepository.updateExitstsAndPersonAndDateForPhone(id, false, person, new Date());
        return phone;
    }

    @Transactional
    public void retrunPhone(long id) {
    }
}
