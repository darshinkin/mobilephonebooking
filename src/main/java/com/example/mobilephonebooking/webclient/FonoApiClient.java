package com.example.mobilephonebooking.webclient;


import com.aafanasev.fonoapi.DeviceEntity;
import com.aafanasev.fonoapi.retrofit.FonoApiFactory;
import com.aafanasev.fonoapi.retrofit.FonoApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class FonoApiClient {

    public void retreiveDevices() {
        FonoApiService api = new FonoApiFactory().create();
        api.getLatest("<token>", "samsung", 10).enqueue(new Callback<List<DeviceEntity>>() {

            @Override
            public void onResponse(Call<List<DeviceEntity>> call, Response<List<DeviceEntity>> response) {
                response.body().forEach(device -> {
                    System.out.println(device.getDeviceName());
                });
            }

            @Override
            public void onFailure(Call<List<DeviceEntity>> call, Throwable t) {}

        });
    }
}
