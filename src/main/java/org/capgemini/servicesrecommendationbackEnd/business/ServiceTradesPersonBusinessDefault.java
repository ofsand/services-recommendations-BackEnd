package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.ServicesTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.ServiceMapper;
import org.capgemini.servicesrecommendationbackEnd.mapper.ServiceTradesPersonMapper;
import org.capgemini.servicesrecommendationbackEnd.mapper.TradesPersonMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.TradesPerson;
import org.capgemini.servicesrecommendationbackEnd.repository.ServiceTradesPersonRepository;


import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceTradesPersonBusinessDefault implements ServiceTradesPersonBusiness {

    private final ServiceTradesPersonRepository serviceTradesPersonRepository;
    private final TradesPersonMapper tradesPersonMapper;
    private final ServiceMapper serviceMapper;

    public List<ServicesTradesPersonDto> getAll() {
         return serviceTradesPersonRepository
                 .findAll()
                 .stream()
                 .map(element -> {
                     if(element instanceof Service) {
                         Service service = (Service) element;
                         return serviceMapper.serviceToServiceDto(service);
                     }
                   else {
                         TradesPerson tradesPerson = (TradesPerson) element;
                         return  tradesPersonMapper.tradesPersonToTradesPersonDto(tradesPerson);
                     }
                 })
                 .collect(Collectors.toList());
    }

    @Override
    public ServiceTradesPerson add(ServiceTradesPerson serviceTradesPerson) {
        return serviceTradesPersonRepository.save(serviceTradesPerson);
    }


    
}
