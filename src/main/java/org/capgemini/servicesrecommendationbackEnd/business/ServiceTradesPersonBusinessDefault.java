package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.ServicesTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.ServiceMapper;
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

    public List<ServicesTradesPersonDto> getAllServicesTradesPersons() {
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
                         return tradesPersonMapper.tradesPersonToTradesPersonDto(tradesPerson);
                     }
                 })
                 .collect(Collectors.toList());
    }

    @Override
    public ServicesTradesPersonDto addServiceTradesPerson(ServiceTradesPerson serviceTradesPerson) {
        if(serviceTradesPerson instanceof Service) {
            Service service = (Service) serviceTradesPerson;
            serviceTradesPersonRepository.save(service);
            return serviceMapper.serviceToServiceDto(service);
        }
        else {
            TradesPerson tradesPerson = (TradesPerson) serviceTradesPerson;
            serviceTradesPersonRepository.save(tradesPerson);
            return tradesPersonMapper.tradesPersonToTradesPersonDto(tradesPerson);
        }
    }

    @Override
    public ServicesTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId) {
        ServiceTradesPerson serviceTradesPerson = serviceTradesPersonRepository.findById(serviceTradesPersonId)
                .orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_ID));
        if(serviceTradesPerson instanceof Service) {
            Service service = (Service) serviceTradesPerson;
            serviceTradesPersonRepository.save(service);
            return serviceMapper.serviceToServiceDto(service);
        }
        else {
            TradesPerson tradesPerson = (TradesPerson) serviceTradesPerson;
            serviceTradesPersonRepository.save(tradesPerson);
            return tradesPersonMapper.tradesPersonToTradesPersonDto(tradesPerson);
        }
    }

    @Override
    public ServicesTradesPersonDto findServiceTradesPersonByTitle(String title) {
        return null;
    }

}
