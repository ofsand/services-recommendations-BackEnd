package org.capgemini.servicesrecommendationbackEnd.business;

import java.util.List;

public interface Service {
    public List<Service> services();
    public void add(Service service);
    public Service get(Long id);
    public Service update(Long id);
    public boolean delete(Long id);
    public void deleteAll();
}
