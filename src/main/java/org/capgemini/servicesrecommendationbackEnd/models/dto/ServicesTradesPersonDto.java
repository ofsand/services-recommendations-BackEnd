package org.capgemini.servicesrecommendationbackEnd.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class ServicesTradesPersonDto {
    private Long id;
    private String title;
    private String email;
    private String phoneNumber;
    private List<RecommendationDto> recommendations;
}
