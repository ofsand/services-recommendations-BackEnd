package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.ServiceTradesPersonServiceInterface;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServicesTradesPersonDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ServiceTradesPersonController {
    private final ServiceTradesPersonServiceInterface serviceTradesPersonBusiness;
    @RequestMapping(method = RequestMethod.GET, value = "/services")
    public List<ServicesTradesPersonDto> findAll() {
        return serviceTradesPersonBusiness.getAllServicesTradesPersons();
    }

    /*
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ServicesTradesPersonDto addServiceTradesPerson(@RequestBody ServicesTradesPersonDto servicesTradesPersonDto){
        return serviceTradesPersonBusiness.addServiceTradesPerson(servicesTradesPersonDto);
    }
    */

}
