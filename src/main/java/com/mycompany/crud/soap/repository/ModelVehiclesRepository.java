package com.mycompany.crud.soap.repository;

import com.mycompany.crud.soap.model.ModelVehicles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ModelVehiclesRepository {

    @PersistenceContext(unitName = "SoapPU")
    private EntityManager em;

    public List<ModelVehicles> findAll() {
        return em.createQuery("SELECT m FROM ModelVehicles m", ModelVehicles.class).getResultList();
    }

    public ModelVehicles findById(Integer id) {
        return em.find(ModelVehicles.class, id);
    }

    @Transactional
    public ModelVehicles save(ModelVehicles model) {
        if (model.getId() == null) {
            em.persist(model);
            return model;
        } else {
            return em.merge(model);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        ModelVehicles model = findById(id);
        if (model != null) {
            em.remove(model);
            return true;
        }
        return false;
    }

    public boolean existsById(Integer id) {
        return findById(id) != null;
    }
}
