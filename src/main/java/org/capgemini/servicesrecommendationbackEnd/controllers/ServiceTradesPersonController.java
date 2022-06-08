package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.TradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.services.service.ServiceTradesPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ServiceTradesPersonController {
    private final ServiceTradesPersonService serviceTradesPersonBusiness;

    @RequestMapping(method = RequestMethod.GET, value = "/services-tradesPerson")
    public List<ServiceTradesPersonDto> findAll() {
        return serviceTradesPersonBusiness.getAllServicesTradesPersons();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{idCategory}/services-tradesPerson")
    public List<ServiceTradesPersonDto> findByCategory(@PathVariable Long idCategory) {
        return serviceTradesPersonBusiness.findByCategory(idCategory);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/category/{idCategory}/services")
    public ServiceDto addService(@RequestBody ServiceDto serviceDto, @PathVariable Long idCategory){
        return serviceTradesPersonBusiness.addService(serviceDto, idCategory);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/category/{idCategory}/tradesPerson")
    public TradesPersonDto addTradesPerson(@RequestBody TradesPersonDto tradesPersonDto, @PathVariable Long idCategory){
        return serviceTradesPersonBusiness.addTradesPerson(tradesPersonDto, idCategory);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tradesPerson")
    public List<TradesPersonDto> findAllTradesPerson() {
        return serviceTradesPersonBusiness.getAllTradesPersons();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/services")
    public List<ServiceDto> findAllServices() {
        return serviceTradesPersonBusiness.getAllServices();
    }



}
