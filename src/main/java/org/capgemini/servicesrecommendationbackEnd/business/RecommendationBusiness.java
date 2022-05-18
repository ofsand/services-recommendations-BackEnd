package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.models.Tradesperson;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.ServiceRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.TradespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class RecommendationBusiness implements EntityBusiness<Recommendation, Long> {


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

    @Override
    public void add(Recommendation objet) {

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
    public void update(Recommendation object) {

    }

    public void updateOnService(Recommendation recommendation, Long serviceId) {
        this.addToService(serviceId, recommendation);
    }
    public void updateOnTradesperson(Recommendation recommendation, Long tradespersonId) {
        this.addToTradesperson(tradespersonId, recommendation);
    }

    public List<Recommendation> getRecommendationsByService(Long serviceId) {
        Service service = serviceRepository.getById(serviceId);

        List<Recommendation> listRecommendations ;
        listRecommendations = service.getRecommendations().stream().filter(Recommendation::isApproved).collect(Collectors.toList());
        return listRecommendations;
    }

    public List<Recommendation> getRecommendationsByTradesperson(Long tradespersonId) {
        Tradesperson tradesperson = tradespersonRepository.getById(tradespersonId);

        List<Recommendation> listRecommendations ;
        listRecommendations = tradesperson.getRecommendations().stream().filter(Recommendation::isApproved).collect(Collectors.toList());
        return listRecommendations;
    }


    @Override
    public void delete(Long id) {
        recommendationRepository.deleteById(id);
    }
}
