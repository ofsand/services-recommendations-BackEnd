package org.capgemini.servicesrecommendationbackEnd.dto;

import lombok.Data;

@Data
public class ServiceDto extends ServiceTradesPersonDto {
    private Long id;
    private String location;
}
