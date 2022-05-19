package org.capgemini.servicesrecommendationbackEnd.repository;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    /*
    @Query("select service as s from Service where s.category.idCategory = :categoryId and s.id = serviceId")
    public Service getByCategory(@Param("categoryId") Long categoryId, @Param("serviceId") Long serviceId);
     */

}
