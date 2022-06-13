package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.models.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.services.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @RequestMapping(value="/recommendations", method = RequestMethod.GET)
    public List<RecommendationDto> findAll() {
        return recommendationService.getAllRecommendations();
    }



    @RequestMapping(value = "/recommendations/{recommendationId}", method = RequestMethod.GET)
    public RecommendationDto findById(@PathVariable Long recommendationId) {
        return recommendationService.getRecommendation(recommendationId);
    }

    @RequestMapping(value="/admin/recommendations/approved=false", method = RequestMethod.GET)
    public List<RecommendationDto> getDisapprovedRecommendations() {
        return recommendationService.getDisapprovedRecommendations();
    }



    @RequestMapping(value = "/services-tradesPerson/{servicesTradesPersonId}/recommendations", method = RequestMethod.GET)
    public List<RecommendationDto> getRecommendationsByServiceTradesperson(@PathVariable Long servicesTradesPersonId) {
        return recommendationService.getApprovedRecByServiceTradesperson(servicesTradesPersonId);
    }

    @RequestMapping(value = "/services-tradesPerson/{servicesTradesPersonId}", method = RequestMethod.POST)
    public RecommendationDto addRecommendationToServiceTradesperson(@PathVariable Long servicesTradesPersonId,
                                                                    @RequestBody RecommendationDto recommendationDto) {
        return recommendationService.addRecommendationToServiceTradesperson(servicesTradesPersonId, recommendationDto);
    }

    @RequestMapping(value = "/admin/recommendations/{recommendationId}/approve", method = RequestMethod.PUT)
    public RecommendationDto approveRecommendation(
            @PathVariable Long recommendationId
    ) {
        return recommendationService.approveRecommendation(recommendationId);
    }

    @RequestMapping(value = "/admin/recommendations/{recommendationId}/decline", method = RequestMethod.PUT)
    public RecommendationDto declineRecommendation(
            @PathVariable Long recommendationId
    ) {
        return recommendationService.declineRecommendation(recommendationId);
    }


}
