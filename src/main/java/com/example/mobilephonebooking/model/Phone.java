package com.example.mobilephonebooking.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PHONE")
@ToString
@Data
@Builder
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private Boolean exist;

    private String model;
    private String brand;
    private boolean availability;
    private Date bookedOut;
    private String person;

    private String technology;
    private String twoGBang;
    private String threeGBang;
    private String fourGBang;
}
