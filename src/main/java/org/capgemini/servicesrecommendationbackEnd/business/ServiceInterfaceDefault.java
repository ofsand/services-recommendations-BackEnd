package org.capgemini.servicesrecommendationbackEnd.business;

import java.util.List;

public class ServiceInterfaceDefault implements ServiceBusiness {
    @Override
    public List<Service> services() {
        return null;
    }

    @Override
    public void add(Service service) {

    }

    @Override
    public Service get(Long id) {
        return null;
    }

    @Override
    public Service update(Long id) {
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
