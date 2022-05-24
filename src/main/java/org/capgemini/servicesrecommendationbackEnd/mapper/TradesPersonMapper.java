package org.capgemini.servicesrecommendationbackEnd.mapper;

import org.capgemini.servicesrecommendationbackEnd.dto.TradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.TradesPerson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TradesPersonMapper {
    TradesPersonDto tradesPersonToTradesPersonDto(TradesPerson tradesPerson);
    TradesPerson tradesPersonDtoToTradesPerson(TradesPersonDto tradesPersonDto);
}
