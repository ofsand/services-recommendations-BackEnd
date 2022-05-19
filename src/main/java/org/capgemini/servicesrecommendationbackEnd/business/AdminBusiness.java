package org.capgemini.servicesrecommendationbackEnd.business;

public interface AdminBusiness {
    public void approveRecommendation(Long recommendationId);
    public void declineRecommendation(Long recommendationId);
}
