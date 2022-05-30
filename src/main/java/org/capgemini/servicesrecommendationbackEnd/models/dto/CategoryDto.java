package org.capgemini.servicesrecommendationbackEnd.models.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class CategoryDto {
    private Long idCategory;
    private String name;
    private List<ServiceTradesPersonDto> serviceTradesPersons=new ArrayList<>();
}

