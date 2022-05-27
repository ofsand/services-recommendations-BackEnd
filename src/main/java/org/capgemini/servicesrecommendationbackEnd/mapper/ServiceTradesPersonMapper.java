package org.capgemini.servicesrecommendationbackEnd.mapper;

import org.capgemini.servicesrecommendationbackEnd.models.dto.ServicesTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.ServiceTradesPerson;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface ServiceTradesPersonMapper {
    ServicesTradesPersonDto serviceTradesPersonToServiceTradesPersonDto(ServiceTradesPerson serviceTradesPerson);
    //ServiceTradesPerson serviceTradesPersonDtoToServiceTradesPerson(ServicesTradesPersonDto serviceTradesPersonDto);
}