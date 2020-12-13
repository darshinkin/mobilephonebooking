package com.example.mobilephonebooking.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "PHONE")
@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Boolean exist;

    private String model;
    private String brand;
    private boolean availability;
    @Column(name = "booked_out")
    private Date bookedOut;
    private String person;

    private String technology;
    private String twoGBang;
    private String threeGBang;
    private String fourGBang;
}
