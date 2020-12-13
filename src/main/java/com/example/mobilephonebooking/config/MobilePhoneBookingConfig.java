package com.example.mobilephonebooking.config;

import com.aafanasev.fonoapi.retrofit.FonoApiFactory;
import com.aafanasev.fonoapi.retrofit.FonoApiService;
import com.example.mobilephonebooking.model.Phone;
import com.example.mobilephonebooking.persistence.PhoneDao;
import com.example.mobilephonebooking.persistence.PhoneRepository;
import com.example.mobilephonebooking.services.BookService;
import com.example.mobilephonebooking.webclient.FonoApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableTransactionManagement
public class MobilePhoneBookingConfig {

    private AtomicInteger count = new AtomicInteger(0);

    @Bean
    FonoApiClient fonoApiClient() {
        return new FonoApiClient(fonoApiService(), token);
    }

    @Bean
    FonoApiService fonoApiService() {
        return new FonoApiFactory().create();
    }

    @Bean
    BookService bookService() {
        BookService bookService = new BookService(fonoApiClient(), phoneDao());
        return bookService;
    }

    @Bean
    PhoneDao phoneDao() {
        return new PhoneDao(phoneRepository);
    }

    @Autowired
    PhoneRepository phoneRepository;

    @EventListener
    void initBookServiceThroughDbContext(ContextRefreshedEvent contextRefreshedEvent) {
        phoneModels.forEach(model -> {
            int separater = model.indexOf(" ");
            String deviceName = model.substring(separater, model.length() - 1);
            String brand = model.substring(0, separater);
            Phone phone = Phone.builder()
                    .availability(true)
                    .model(deviceName)
                    .brand(brand)
                    .exist(true)
                    .build();
            phoneRepository.save(phone);
        });
    }

    private void initBookServiceThroughMap(BookService bookService) {
        Map<Integer, Phone> phones = new HashMap<>();
        int id = count.addAndGet(1);
        phoneModels.forEach(model -> {
            int separater = model.indexOf(" ");
            String deviceName = model.substring(separater, model.length() - 1);
            String brand = model.substring(0, separater);
            phones.put(id, Phone.builder()
                    .id(id)
                    .availability(true)
                    .model(deviceName)
                    .brand(brand)
                    .build());
        });
        bookService.setPhones(phones);
    }

    @Value("#{'${app.phones}'.split(',')}")
    private List<String> phoneModels;

    @Value("app.token")
    private String token;
}
