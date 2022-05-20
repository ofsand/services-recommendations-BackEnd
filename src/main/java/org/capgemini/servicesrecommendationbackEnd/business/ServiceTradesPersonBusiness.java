package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.ServicesTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;

import java.util.List;

public interface ServiceTradesPersonBusiness {
    List<ServicesTradesPersonDto> getAllServicesTradesPersons();
    ServicesTradesPersonDto addServiceTradesPerson(ServiceTradesPerson serviceTradesPerson);
    ServicesTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId);

}
