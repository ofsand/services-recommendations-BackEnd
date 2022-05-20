package org.capgemini.servicesrecommendationbackEnd.dto;

import lombok.Data;

@Data
public class RecommendationDto {
    private Long idRecommendation;
    private String comment;
    private boolean isApproved;
    private int numberStars;
    private UserDto user;
}
