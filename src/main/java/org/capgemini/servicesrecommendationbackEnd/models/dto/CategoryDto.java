package org.capgemini.servicesrecommendationbackEnd.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long idCategory;
    private String name;
    private List<ServicesTradesPersonDto> servicesTradesPersons;
}

