package com.example.mobilephonebooking.persistence;

import com.example.mobilephonebooking.model.Phone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PhoneRepository extends CrudRepository<Phone, Long> {

    @Modifying
    @Query("update PHONE ph set ph.exist = :exist, ph.person = :person, ph.booked_out = :date where ph.id = :id")
    void updateExitstsAndPersonAndDateForPhone(@Param(value = "id") long id, @Param(value = "exist") Boolean exist,
                                               @Param(value = "person") String person, @Param(value = "date") Date date);

    @Modifying
    @Query("update PHONE ph set ph.exist = :exist where ph.id = :id")
    void updateExistsPhone(@Param(value = "id") long id, @Param(value = "exist") Boolean exist);
}
