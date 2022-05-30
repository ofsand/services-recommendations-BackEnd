package org.capgemini.servicesrecommendationbackEnd.models.dto;

import lombok.Data;

@Data
public class RecommendationDto {
    private Long idRecommendation;
    private String comment;
    private boolean isApproved;
    private int numberStars;
    private UserDto user;
}
