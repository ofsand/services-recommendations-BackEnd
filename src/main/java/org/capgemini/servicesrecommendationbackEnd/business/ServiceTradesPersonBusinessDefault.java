package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.capgemini.servicesrecommendationbackEnd.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.dto.ServiceTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.dto.TradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.TradesPerson;
import org.capgemini.servicesrecommendationbackEnd.repository.ServiceTradesPersonRepository;


import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Slf4j
public class ServiceTradesPersonBusinessDefault implements ServiceTradesPersonBusiness {

    private final ServiceTradesPersonRepository serviceTradesPersonRepository;
    private final RecommendationMapper recommendationMapper;
    private final CategoryBusiness categoryBusiness;


    @Override
    public TradesPersonDto addTradesPerson(TradesPersonDto tradesPersonDto, Long idCategory) {
        Category category = recommendationMapper.toCategory(categoryBusiness.getCategory(idCategory));
        TradesPerson tradesPerson = recommendationMapper.tradesPersonDtoToTradesPerson(tradesPersonDto);
        tradesPerson.setCategory(category);
        TradesPerson savedTradesPerson =
                serviceTradesPersonRepository.save(tradesPerson);
        return recommendationMapper.tradesPersonToTradesPersonDto(savedTradesPerson);
    }

    @Override
    public ServiceDto addService(ServiceDto serviceDto, Long idCategory) {
        Category category = recommendationMapper.toCategory(categoryBusiness.getCategory(idCategory));
        Service service = recommendationMapper.serviceDtoToService(serviceDto);
        service.setCategory(category);
        Service savedService =
                serviceTradesPersonRepository.save(service);
        return recommendationMapper.serviceToServiceDto(savedService);
    }

    @Override
    public List<ServiceTradesPersonDto> findByCategory(Long idCategory) {
        Category category = recommendationMapper.toCategory(categoryBusiness.getCategory(idCategory));
        return
            serviceTradesPersonRepository
            .findByCategory(category)
                    .stream()
                    .map(recommendationMapper::toServiceTradesPersonDto).collect(Collectors.toList());
    }

    @Override
    public ServiceTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId) {
        ServiceTradesPerson serviceTradesPerson =  serviceTradesPersonRepository
                .findById(serviceTradesPersonId)
                .orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_ID));
        return recommendationMapper.toServiceTradesPersonDto(serviceTradesPerson);
    }

    @Override
    public List<ServiceTradesPersonDto> getAllServicesTradesPersons() {
        return serviceTradesPersonRepository
                .findAll()
                .stream()
                .map(recommendationMapper::toServiceTradesPersonDto).collect(Collectors.toList());
    }


/*
    @Override
    public ServiceTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId) {
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
*/
}
