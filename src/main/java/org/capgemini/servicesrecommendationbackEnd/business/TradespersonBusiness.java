package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Tradesperson;

import java.util.List;

public interface TradespersonBusiness {
    public List<Tradesperson> getAll();
    public Tradesperson get(Long TradespersonId);
    public void add(Long categoryId, Tradesperson Tradesperson);
    public void update(Tradesperson Tradesperson);
    public void delete(Long TradespersonId);
}
