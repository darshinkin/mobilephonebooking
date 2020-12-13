package com.example.mobilephonebooking.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@ToString
@Data
@Builder
public class Phone {

    private int id;
    private String model;
    private String brand;
    private boolean availability;
    private Date bookedOut;

    private String technology;
    private String twoGBang;
    private String threeGBang;
    private String fourGBang;
}
