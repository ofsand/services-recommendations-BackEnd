package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.business.RecommendationBusiness;
import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecommendationController {
    private final RecommendationBusiness recommendationBusiness;
    private final CategoryController categoryRepository;

    @RequestMapping(value="/recommendations", method = RequestMethod.GET)
    public List<RecommendationDto> findAll() {
        return recommendationBusiness.getAllRecommendations();
    }

    @RequestMapping(value = "/recommendations/{recommendationId}", method = RequestMethod.GET)
    public RecommendationDto findById(@PathVariable Long recommendationId) {
        return recommendationBusiness.getRecommendation(recommendationId);
    }

}
