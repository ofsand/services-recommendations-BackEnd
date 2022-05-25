package org.capgemini.servicesrecommendationbackEnd.mapper;

import org.capgemini.servicesrecommendationbackEnd.dto.*;
import org.capgemini.servicesrecommendationbackEnd.models.*;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    default ServiceTradesPersonDto toServiceTradesPersonDto(ServiceTradesPerson serviceTradesPerson) {

        if(serviceTradesPerson instanceof Service) {
            Service service = (Service) serviceTradesPerson;
            ServiceDto serviceDto = serviceToServiceDto(service);
            serviceDto.setType(serviceDto.getClass().getSimpleName());
            return serviceDto;
        }
        else {
            TradesPerson tradesPerson = (TradesPerson) serviceTradesPerson;
            TradesPersonDto tradesPersonDto =  tradesPersonToTradesPersonDto(tradesPerson);
            tradesPersonDto.setType(tradesPersonDto.getClass().getSimpleName());
            return tradesPersonDto;
        }
    }

    default ServiceTradesPerson toServiceTradesPerson(ServiceTradesPersonDto serviceTradesPersonDto) {
        if(serviceTradesPersonDto instanceof ServiceDto) {
            ServiceDto serviceDto = (ServiceDto) serviceTradesPersonDto;
            return serviceDtoToService(serviceDto);
        }
        else {
            TradesPersonDto tradesPersonDto = (TradesPersonDto) serviceTradesPersonDto;
            return tradesPersonDtoToTradesPerson(tradesPersonDto);
        }
    }

    ServiceDto serviceToServiceDto(Service service);
    Service serviceDtoToService(ServiceDto serviceDto);
    TradesPersonDto tradesPersonToTradesPersonDto(TradesPerson tradesPerson);
    TradesPerson tradesPersonDtoToTradesPerson(TradesPersonDto tradesPersonDto);

    CategoryDto toCategoryDto(Category category);
    Category toCategory(CategoryDto categoryDto);

    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}