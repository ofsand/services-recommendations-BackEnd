package org.capgemini.servicesrecommendationbackEnd.business;

import java.util.List;

public interface CategoryBusiness {
    public List<Category> categories();
    public void add(Category category);
    public void addService(Service service);
    public void addTradesPerson(TradesPerson tradesPerson);
    public Category get(Long id);
    public List<Services> getServices();
    public List<TradesPerson> getTradesPerson();
    public Category update(Long id);
    public boolean delete(Long id);
    public void deleteAll();
}
