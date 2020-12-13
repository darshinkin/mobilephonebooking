package com.example.mobilephonebooking.webclient;


import com.aafanasev.fonoapi.DeviceEntity;
import com.aafanasev.fonoapi.retrofit.FonoApiService;
import com.example.mobilephonebooking.model.Phone;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import retrofit2.Response;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class FonoApiClient {

    private final FonoApiService api;
    private final String token;


    @SneakyThrows
    public Optional<DeviceEntity> retreiveDevice(Phone phone) {
        Response<List<DeviceEntity>> execute = api.getDevice(token, phone.getModel(), phone.getBrand(), null).execute();
        List<DeviceEntity> body = execute.body();
        return Objects.requireNonNull(body).stream().findAny();
    }
}
