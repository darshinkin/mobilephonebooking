package com.example.mobilephonebooking.services;

import com.aafanasev.fonoapi.DeviceEntity;
import com.example.mobilephonebooking.model.Phone;
import com.example.mobilephonebooking.persistence.PhoneDao;
import com.example.mobilephonebooking.webclient.FonoApiClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Data
public class BookService implements BookingPhone, ReturnPhone {

    private final FonoApiClient fonoApiClient;
    private final PhoneDao phoneDao;

    private Map<Integer, Phone> phones = new ConcurrentHashMap<>();

    @Override
    public Optional<Phone> book(long id, String person) {
        Optional<Phone> maybePhone = phoneDao.retreivePhoneById(id, person);
        if (maybePhone.isEmpty() || !maybePhone.get().getExist()) {
            return Optional.empty();
        }
        Phone phone = maybePhone.get();
        Optional<DeviceEntity> deviceEntity = fonoApiClient.retreiveDevice(phone);
        deviceEntity.ifPresent(entity -> {
            phone.setTechnology(entity.getTechnology());
            phone.setTwoGBang(entity.get_2g_bands());
            phone.setThreeGBang(entity.get_3g_bands());
            phone.setFourGBang(entity.get_4g_bands());
        });
        return Optional.of(phone);
    }

    @Override
    public void returnPhone(long id) {
        phoneDao.retrunPhone(id);
    }
}
