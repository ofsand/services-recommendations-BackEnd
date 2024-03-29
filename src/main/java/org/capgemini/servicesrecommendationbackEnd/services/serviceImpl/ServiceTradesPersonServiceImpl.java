package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.TradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.*;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.repositories.*;
import org.capgemini.servicesrecommendationbackEnd.services.service.CategoryService;
import org.capgemini.servicesrecommendationbackEnd.services.service.ServiceTradesPersonService;


import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceTradesPersonServiceImpl implements ServiceTradesPersonService {
    private final ServiceTradesPersonRepository serviceTradesPersonRepository;
    private final RecommendationMapper recommendationMapper;
    private final CategoryService categoryBusiness;


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
    public List<ServiceTradesPersonDto> findByCategory(Long idCategory, String keyword) {
        Category category = recommendationMapper.toCategory(categoryBusiness.getCategory(idCategory));
        return
            serviceTradesPersonRepository
                .findByCategory(category)
                .stream().filter(
                        serviceTradesPerson ->
                                serviceTradesPerson.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                            serviceTradesPerson.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .map(recommendationMapper::toServiceTradesPersonDto).collect(Collectors.toList());

    }

    @Override
    public TradesPersonDto findTradePersonById(Long id) {
        return recommendationMapper.tradesPersonToTradesPersonDto( serviceTradesPersonRepository.findTradePersonById(id));

    }

    @Override
    public ServiceDto findServiceById(Long id) {
        return recommendationMapper.serviceToServiceDto( serviceTradesPersonRepository.findServiceById(id));
    }

    @Override
    public ServiceTradesPersonDto findServiceTradesPersonById(Long serviceTradesPersonId) {
        ServiceTradesPerson serviceTradesPerson =  serviceTradesPersonRepository
                .findById(serviceTradesPersonId)
                .orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_ID));
        return recommendationMapper.toServiceTradesPersonDto(serviceTradesPerson);
    }

    @Override
    public List<TradesPersonDto> getAllTradesPersonsByCategory(Long idCategory, String keyword) {
        return
            serviceTradesPersonRepository
                .findAllTradesPerson(idCategory,keyword)
                .stream()
                .map(recommendationMapper::tradesPersonToTradesPersonDto)
                .peek((TradesPersonDto tradesPersonDto) -> tradesPersonDto.setType(tradesPersonDto.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ServiceDto> getAllServicesByCategory(Long idCategory, String keyword) {
        return
            serviceTradesPersonRepository
                .findAllServices(idCategory,keyword)
                .stream()
                .map(recommendationMapper::serviceToServiceDto)
                .peek((ServiceDto serviceDto) -> serviceDto.setType(serviceDto.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TradesPersonDto> getAllTradesPersons(String keyword) {
        return
            serviceTradesPersonRepository
                .findAllTradesPerson(keyword)
                .stream()
                .map(recommendationMapper::tradesPersonToTradesPersonDto)
                .peek((TradesPersonDto tradesPersonDto) -> tradesPersonDto.setType(tradesPersonDto.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ServiceDto> getAllServices(String keyword) {
        return
            serviceTradesPersonRepository
                .findAllServices(keyword)
                .stream()
                .map(recommendationMapper::serviceToServiceDto)
                .peek((ServiceDto serviceDto) -> serviceDto.setType(serviceDto.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteServiceTradePerson(Long idServiceTradesPerson) {
        serviceTradesPersonRepository.deleteById(idServiceTradesPerson);
    }

    @Override
    public List<ServiceTradesPersonDto> getAllServicesTradesPersons(String keyword) {
        return serviceTradesPersonRepository
                .findAllByKeyword(keyword)
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