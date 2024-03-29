package org.capgemini.servicesrecommendationbackEnd.repositories;

import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceTradesPersonDto;
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

    @Query("select t from ServiceTradesPerson t where title like %:keyword% or description like %:keyword%   ")
    List<ServiceTradesPerson> findAllByKeyword(@Param("keyword") String keyword);
    @Query("select t from TradesPerson t where id_category = :idCategory and (title like %:keyword% or description like %:keyword%  ) ")
    List<TradesPerson> findAllTradesPerson(@Param("idCategory")Long idCategory,@Param("keyword") String keyword);
    @Query("select t from TradesPerson t where id = :id")
    TradesPerson findTradePersonById(@Param("id") Long id);

    @Query("select t from Service t where id = :id")
    Service findServiceById(@Param("id") Long id);

    @Query("select s from Service s where id_category = :idCategory and  (title like %:keyword% or description like %:keyword% )  ")
    List<Service> findAllServices(@Param("idCategory") Long idCategory,@Param("keyword") String keyword);
    @Query("select t from TradesPerson t where   (title like %:keyword% or description like %:keyword% )  ")
    List<TradesPerson> findAllTradesPerson(@Param("keyword") String keyword);
    @Query("select s from Service s where  (title like %:keyword% or description like %:keyword% )  ")
    List<Service> findAllServices(@Param("keyword") String keyword);
}
