package org.capgemini.servicesrecommendationbackEnd.mapper;


import org.capgemini.servicesrecommendationbackEnd.models.dto.*;
import org.capgemini.servicesrecommendationbackEnd.models.entities.*;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    default ServiceTradesPersonDto toServiceTradesPersonDto(ServiceTradesPerson serviceTradesPerson) {
        if(serviceTradesPerson instanceof Service) {
            Service service = (Service) serviceTradesPerson;
            return  serviceToServiceDto(service);
        }
        else {
            TradesPerson tradesPerson = (TradesPerson) serviceTradesPerson;
            return tradesPersonToTradesPersonDto(tradesPerson);
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

    Recommendation toRecommendation(RecommendationDto recommendationDto);
    RecommendationDto toRecommendationDto(Recommendation recommendation);
}