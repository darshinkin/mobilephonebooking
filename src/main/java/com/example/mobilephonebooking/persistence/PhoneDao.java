package com.example.mobilephonebooking.persistence;

import com.example.mobilephonebooking.model.Phone;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
public class PhoneDao {

    private final PhoneRepository phoneRepository;


    @Transactional
    public Optional<Phone> retreivePhoneById(long id) {
        Optional<Phone> phone = phoneRepository.findById(id);
        phoneRepository.updatePhone(id, false);
        return phone;
    }

    @Transactional
    public void retrunPhone(long id) {
        phoneRepository.updatePhone(id, true);
    }
}
