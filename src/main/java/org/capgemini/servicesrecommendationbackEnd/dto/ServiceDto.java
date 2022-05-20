package org.capgemini.servicesrecommendationbackEnd.dto;

import lombok.Data;

@Data
public class ServiceDto extends ServicesTradesPersonDto {
    private Long id;
    private String location;
}
