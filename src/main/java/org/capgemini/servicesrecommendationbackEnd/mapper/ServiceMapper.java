package org.capgemini.servicesrecommendationbackEnd.mapper;

import org.capgemini.servicesrecommendationbackEnd.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.dto.TradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.models.TradesPerson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    ServiceDto serviceToServiceDto(Service service);
    Service serviceDtoToService(ServiceDto serviceDto);
}
