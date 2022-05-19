package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.models.Tradesperson;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.ServiceRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.TradespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecommendationBusinessDefault implements RecommendationBusiness {

    @Autowired
    public TradespersonRepository tradespersonRepository;

    @Autowired
    public ServiceRepository serviceRepository;

    @Autowired
    public RecommendationRepository recommendationRepository;

    @Override
    public List<Recommendation> getAll() {
        return recommendationRepository.findAll();
    }

    @Override
    public Recommendation get(Long id) {
        return recommendationRepository.getById(id);
    }

    public void addToService(Long serviceId, Recommendation recommendation) {
        Service service = serviceRepository.getById(serviceId);
        recommendation.setService(service);

        /*
        List<Recommendation> listRecommendations ;
        listRecommendations = service.getRecommendations();
        listRecommendations.add(recommendation);
        service.setRecommendations(listRecommendations);

        // service.getRecommendations().add(recommendation);
        */

        recommendationRepository.save(recommendation);
    }


    public void addToTradesperson(Long tradespersonId, Recommendation recommendation) {
        Tradesperson tradesperson = tradespersonRepository.getById(tradespersonId);
        recommendation.setTradesperson(tradesperson);

        /*
        List<Recommendation> listRecommendations ;
        listRecommendations = tradesperson.getRecommendations();
        listRecommendations.add(recommendation);
        tradesperson.setRecommendations(listRecommendations);

        // tradesperson.getRecommendations().add(recommendation);
        */

        recommendationRepository.save(recommendation);
    }

    @Override
    public void update(Recommendation recommendation) {
        recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getRecommendationsByService(Long serviceId) {
        /*
        Service service = serviceRepository.getById(serviceId);

        List<Recommendation> listRecommendations ;
        listRecommendations = service.getRecommendations().stream().filter(Recommendation::isApproved).collect(Collectors.toList());
        return listRecommendations;
        */
        return recommendationRepository.getRecommendationsByService(serviceId);
    }

    public List<Recommendation> getRecommendationsByTradesperson(Long tradespersonId) {
        /*
        Tradesperson tradesperson = tradespersonRepository.getById(tradespersonId);

        List<Recommendation> listRecommendations ;
        listRecommendations = tradesperson.getRecommendations().stream().filter(Recommendation::isApproved).collect(Collectors.toList());
        return listRecommendations;
        */

        return recommendationRepository.getRecommendationsByTradesperson(tradespersonId);
    }


    @Override
    public void delete(Long id) {
        recommendationRepository.deleteById(id);
    }
}
