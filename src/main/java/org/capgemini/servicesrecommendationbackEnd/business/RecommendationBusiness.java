package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;

import java.util.List;

public interface RecommendationBusiness {
    public List<Recommendation> getAll();
    public Recommendation get(Long recommendationId);
    public List<Recommendation> getRecommendationsByService(Long serviceId);
    public List<Recommendation> getRecommendationsByTradesperson(Long tradespersonId);
    public void addToService(Long serviceId, Recommendation recommendation);
    public void addToTradesperson(Long tradespersonId, Recommendation recommendation);
    public void update(Recommendation recommendation);
    public void delete(Long recommendationId);
}
