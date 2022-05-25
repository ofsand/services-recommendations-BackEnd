package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.dto.ServiceTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.dto.TradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.Service;

import java.util.List;

public interface ServiceTradesPersonBusiness {
    List<ServiceTradesPersonDto> getAllServicesTradesPersons();
    ServiceDto addService(ServiceDto serviceDto, Long idCategory);
    TradesPersonDto addTradesPerson(TradesPersonDto tradesPersonDto, Long idCategory);
    List<ServiceTradesPersonDto> findByCategory(Long idCategory);
    ServiceTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId);
}
