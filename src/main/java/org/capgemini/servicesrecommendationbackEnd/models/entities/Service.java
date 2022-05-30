package org.capgemini.servicesrecommendationbackEnd.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Service extends ServiceTradesPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Long id;
    private String location;

}
