package org.capgemini.servicesrecommendationbackEnd.mapper;

import org.capgemini.servicesrecommendationbackEnd.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    RecommendationDto recommendationToRecommendationDto(Recommendation recommendation);
}
