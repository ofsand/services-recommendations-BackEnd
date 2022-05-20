package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.business.ServiceTradesPersonBusiness;
import org.capgemini.servicesrecommendationbackEnd.dto.ServicesTradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ServiceTradesPersonController {
    private final ServiceTradesPersonBusiness serviceTradesPersonBusiness;
    @RequestMapping(method = RequestMethod.GET, value = "/services")
    public List<ServicesTradesPersonDto> findAll() {
        return serviceTradesPersonBusiness.getAll();
    }
}
