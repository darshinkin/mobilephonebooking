package com.example.mobilephonebooking.services;

import com.aafanasev.fonoapi.DeviceEntity;
import com.example.mobilephonebooking.model.Phone;
import com.example.mobilephonebooking.webclient.FonoApiClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import retrofit2.Call;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Data
public class BookService implements BookingPhone, ReturnPhone {

    private final FonoApiClient fonoApiClient;

    private Map<Integer, Phone> phones = new ConcurrentHashMap<>();

    @Override
    public Optional<Phone> book(int id) {
        Phone phone = phones.get(id);
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
    public Phone returnPhone(int id) {
        return null;
    }
}
