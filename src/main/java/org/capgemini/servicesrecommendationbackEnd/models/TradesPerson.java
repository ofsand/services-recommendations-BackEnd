package org.capgemini.servicesrecommendationbackEnd.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class TradesPerson extends ServiceTradesPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String domain;
    private String speciality;
    private String address;
}
