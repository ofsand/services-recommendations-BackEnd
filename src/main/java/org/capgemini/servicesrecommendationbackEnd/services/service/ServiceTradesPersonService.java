package org.capgemini.servicesrecommendationbackEnd.services.service;

import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.TradesPersonDto;

import java.util.List;

public interface ServiceTradesPersonService {
    List<ServiceTradesPersonDto> getAllServicesTradesPersons();
    ServiceDto addService(ServiceDto serviceDto, Long idCategory);
    TradesPersonDto addTradesPerson(TradesPersonDto tradesPersonDto, Long idCategory);
    List<ServiceTradesPersonDto> findByCategory(Long idCategory);
    ServiceTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId);
}
