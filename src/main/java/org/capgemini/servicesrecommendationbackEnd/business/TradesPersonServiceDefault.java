package org.capgemini.servicesrecommendationbackEnd.business;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TradesPersonServiceDefault implements TradesPersonService{

    @Autowired
    public TradesPersonRepository tradesPersonRepository;

    @Override
    public List<TradesPerson> tradesPersons() {
        return tradesPersonRepository.findAll();
    }

    @Override
    public void add(TradesPerson tradesPerson) {

    }

    @Override
    public TradesPerson get(Long id) {
        return null;
    }

    @Override
    public TradesPerson update(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void deleteAll() {

    }
}
