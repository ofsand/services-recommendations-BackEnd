package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.business.RecommendationBusiness;
import org.capgemini.servicesrecommendationbackEnd.dto.RecommendationDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecommendationController {
    private final RecommendationBusiness recommendationBusiness;
    @RequestMapping(value="/recommendations", method = RequestMethod.GET)
    public List<RecommendationDto> findAll() {
        return recommendationBusiness.getAllRecommendations();
    }
}
