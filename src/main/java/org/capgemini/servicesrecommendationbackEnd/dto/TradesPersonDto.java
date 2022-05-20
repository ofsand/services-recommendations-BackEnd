package org.capgemini.servicesrecommendationbackEnd.dto;

import lombok.Data;

@Data
public class TradesPersonDto extends ServicesTradesPersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String domain;
    private String speciality;
    private String address;
}
