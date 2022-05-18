package org.capgemini.servicesrecommendationbackEnd.business;

import java.util.List;

public interface TradesPersonService {
    public List<TradesPerson> tradesPersons();
    public void add(TradesPerson tradesPerson);
    public TradesPerson get(Long id);
    public TradesPerson update(Long id);
    public boolean delete(Long id);
    public void deleteAll();
}
