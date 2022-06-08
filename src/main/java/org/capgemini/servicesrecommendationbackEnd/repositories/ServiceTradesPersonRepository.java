package org.capgemini.servicesrecommendationbackEnd.repositories;

import org.capgemini.servicesrecommendationbackEnd.models.entities.Category;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Service;
import org.capgemini.servicesrecommendationbackEnd.models.entities.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.entities.TradesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceTradesPersonRepository extends JpaRepository<ServiceTradesPerson, Long> {
    List<ServiceTradesPerson> findByCategory(Category category);

    @Query("select t from TradesPerson t where id_category = :idCategory")
    List<TradesPerson> findAllTradesPerson(@Param("idCategory")Long idCategory);

    @Query("select s from Service s where id_category = :idCategory")
    List<Service> findAllServices(@Param("idCategory") Long idCategory);
}
