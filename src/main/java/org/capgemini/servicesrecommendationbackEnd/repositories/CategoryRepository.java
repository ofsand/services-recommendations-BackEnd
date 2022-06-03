package org.capgemini.servicesrecommendationbackEnd.repositories;

import org.capgemini.servicesrecommendationbackEnd.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
