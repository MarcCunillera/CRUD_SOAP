package com.mycompany.crud.soap.repository;

import com.mycompany.crud.soap.model.MarcaVehicle;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MarcaVehicleRepository {

    @PersistenceContext(unitName = "SoapPU")
    private EntityManager em;

    public List<MarcaVehicle> findAll() {
        return em.createQuery("SELECT m FROM MarcaVehicle m", MarcaVehicle.class).getResultList();
    }

    public MarcaVehicle findById(Integer id) {
        return em.find(MarcaVehicle.class, id);
    }

    @Transactional
    public MarcaVehicle save(MarcaVehicle marca) {
        if (marca.getId() == null) {
            em.persist(marca);
            return marca;
        } else {
            return em.merge(marca);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        MarcaVehicle marca = findById(id);
        if (marca != null) {
            em.remove(marca);
            return true;
        }
        return false;
    }

    public boolean existsById(Integer id) {
        return findById(id) != null;
    }
}
