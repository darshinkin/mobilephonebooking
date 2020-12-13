package com.example.mobilephonebooking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;

@ToString
@Getter
@Builder
public class Phone {

    private int id;
    private String model;
    private boolean availability;
    private Date bookedOut;

    private String technology;
    private String twoGBang;
    private String threeGBang;
    private String fourGBang;
}
