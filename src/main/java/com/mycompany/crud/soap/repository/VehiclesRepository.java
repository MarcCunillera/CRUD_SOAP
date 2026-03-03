package com.mycompany.crud.soap.repository;

import com.mycompany.crud.soap.model.Vehicles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class VehiclesRepository {

    @PersistenceContext(unitName = "SoapPU")
    private EntityManager em;

    public List<Vehicles> findAll() {
        return em.createQuery("SELECT v FROM Vehicles v", Vehicles.class).getResultList();
    }

    public Vehicles findById(Integer id) {
        return em.find(Vehicles.class, id);
    }

    public List<Vehicles> findByBrandId(Integer brandId) {
        return em.createQuery(
                "SELECT v FROM Vehicles v WHERE v.brandId.id = :brandId", Vehicles.class)
                .setParameter("brandId", brandId).getResultList();
    }

    public List<Vehicles> findByModelId(Integer modelId) {
        return em.createQuery(
                "SELECT v FROM Vehicles v WHERE v.modelId.id = :modelId", Vehicles.class)
                .setParameter("modelId", modelId).getResultList();
    }

    @Transactional
    public Vehicles save(Vehicles vehicle) {
        if (vehicle.getId() == null) {
            em.persist(vehicle);
            return vehicle;
        } else {
            return em.merge(vehicle);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        Vehicles vehicle = findById(id);
        if (vehicle != null) {
            em.remove(vehicle);
            return true;
        }
        return false;
    }

    public boolean existsById(Integer id) {
        return findById(id) != null;
    }
}
