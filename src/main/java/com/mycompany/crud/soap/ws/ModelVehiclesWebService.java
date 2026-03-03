package com.mycompany.crud.soap.ws;

import com.mycompany.crud.soap.model.ModelVehicles;
import com.mycompany.crud.soap.repository.MarcaVehicleRepository;
import com.mycompany.crud.soap.repository.ModelVehiclesRepository;
import jakarta.inject.Inject;
import jakarta.jws.HandlerChain;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(serviceName = "ModelVehiclesService")
@HandlerChain(file = "handler-chain.xml")
public class ModelVehiclesWebService {

    @Inject
    private ModelVehiclesRepository repo;

    @Inject
    private MarcaVehicleRepository marcaRepo;

    @WebMethod
    public String crearModel(@WebParam(name = "modelName") String modelName,
                             @WebParam(name = "brandId") Integer brandId) {
        ModelVehicles m = new ModelVehicles();
        m.setModelName(modelName);
        m.setBrandId(marcaRepo.findById(brandId));
        repo.save(m);
        return "Model guardat!";
    }

    @WebMethod
    public List<ModelVehicles> llistarModels() {
        return repo.findAll();
    }

    @WebMethod
    public String eliminarModel(@WebParam(name = "id") Integer id) {
        return repo.delete(id) ? "Eliminat correctament" : "No s'ha trobat l'ID";
    }
}
