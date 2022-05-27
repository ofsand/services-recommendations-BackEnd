package org.capgemini.servicesrecommendationbackEnd.services.serviceInterface;

import org.capgemini.servicesrecommendationbackEnd.models.dto.ServicesTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.ServiceTradesPerson;

import java.util.List;

public interface ServiceTradesPersonServiceInterface {
    List<ServicesTradesPersonDto> getAllServicesTradesPersons();
    ServicesTradesPersonDto addServiceTradesPerson(ServiceTradesPerson serviceTradesPerson);
    ServicesTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId);

    ServicesTradesPersonDto findServiceTradesPersonByTitle(String title);
}
