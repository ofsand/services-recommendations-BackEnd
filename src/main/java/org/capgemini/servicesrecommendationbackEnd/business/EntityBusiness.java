package org.capgemini.servicesrecommendationbackEnd.business;

import java.util.List;

public interface EntityBusiness<T, E> {

        public List<T> getAll();
        public T get(E id) ;
        public void add(T objet);
        public void update(T object, E id);
        public void delete(E id);
}
