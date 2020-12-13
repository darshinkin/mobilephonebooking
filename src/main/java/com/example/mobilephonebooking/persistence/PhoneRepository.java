package com.example.mobilephonebooking.persistence;

import com.example.mobilephonebooking.model.Phone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PhoneRepository extends CrudRepository<Phone, Long> {

    @Modifying
    @Query("update Phone ph set ph.exists = :exists where ph.id = :id")
    void updatePhone(@Param(value = "id") long id, @Param(value = "exists") Boolean exists);
}
