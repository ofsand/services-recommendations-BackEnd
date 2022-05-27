package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.models.dto.*;
import org.capgemini.servicesrecommendationbackEnd.models.entities.*;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessageException;
import org.capgemini.servicesrecommendationbackEnd.mapper.ServiceMapper;
import org.capgemini.servicesrecommendationbackEnd.mapper.TradesPersonMapper;
import org.capgemini.servicesrecommendationbackEnd.repositories.*;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.ServiceTradesPersonServiceInterface;


import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceTradesPersonServiceImpl implements ServiceTradesPersonServiceInterface {
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
                .orElseThrow(() -> new BusinessException(ErrorsMessageException.NOT_FOUND_ID));
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