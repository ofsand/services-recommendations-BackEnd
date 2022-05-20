package org.capgemini.servicesrecommendationbackEnd.controllers;

import org.capgemini.servicesrecommendationbackEnd.business.AdminBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class AdminController {

    @Autowired
    private AdminBusiness adminBusiness;

    @RequestMapping(method = RequestMethod.POST, value = "/approve")
    public void approveRecommendation(@PathVariable Long recommendationId){};

    @RequestMapping(method = RequestMethod.GET, value = "/decline")
    public void declineRecommendation(@RequestBody Long recommendationId){};
}
