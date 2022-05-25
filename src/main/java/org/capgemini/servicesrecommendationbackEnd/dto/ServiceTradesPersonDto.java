package org.capgemini.servicesrecommendationbackEnd.dto;

import lombok.Data;

import java.util.List;

@Data
public abstract class ServiceTradesPersonDto {
    private Long id;
    private String type;
    private String title;
    private String email;
    private String phoneNumber;
    private List<RecommendationDto> recommendations;
}
