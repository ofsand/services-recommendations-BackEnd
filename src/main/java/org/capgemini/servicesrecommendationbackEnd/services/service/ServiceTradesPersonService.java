package org.capgemini.servicesrecommendationbackEnd.services.service;

import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.TradesPersonDto;

import java.util.List;

public interface ServiceTradesPersonService {

    List<ServiceTradesPersonDto> getAllServicesTradesPersons(String keyword);
    ServiceDto addService(ServiceDto serviceDto, Long idCategory);
    TradesPersonDto addTradesPerson(TradesPersonDto tradesPersonDto, Long idCategory);
    List<ServiceTradesPersonDto> findByCategory(Long idCategory, String keyword);
    ServiceTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId);

    List<TradesPersonDto> getAllTradesPersonsByCategory(Long idCategory, String keyword);

    List<ServiceDto> getAllServicesByCategory(Long idCategory, String keyword);

    List<TradesPersonDto> getAllTradesPersons( String keyword);

    List<ServiceDto> getAllServices( String keyword);

    void deleteServiceTradePerson(Long idServiceTradesPerson);
}
