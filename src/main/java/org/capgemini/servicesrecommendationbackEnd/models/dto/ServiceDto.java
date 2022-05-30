package org.capgemini.servicesrecommendationbackEnd.models.dto;

import lombok.Data;

@Data
public class ServiceDto extends ServiceTradesPersonDto {
    private Long id;
    private String location;
}
