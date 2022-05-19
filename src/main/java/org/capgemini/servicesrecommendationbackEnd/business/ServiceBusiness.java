package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Service;

import java.util.List;

public interface ServiceBusiness {
    public List<Service> getAll();
    public Service get(Long ServiceId);
    public void add(Long categoryId, Service service);
    public void update(Service service);
    public void delete(Long serviceId);
}
