package com.mycompany.crud.soap.ws;

import com.mycompany.crud.soap.model.Vehicles;
import com.mycompany.crud.soap.repository.MarcaVehicleRepository;
import com.mycompany.crud.soap.repository.ModelVehiclesRepository;
import com.mycompany.crud.soap.repository.VehiclesRepository;
import jakarta.inject.Inject;
import jakarta.jws.HandlerChain;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(serviceName = "VehiclesService")
@HandlerChain(file = "handler-chain.xml")
public class VehiclesWebService {

    @Inject
    private VehiclesRepository repo;

    @Inject
    private MarcaVehicleRepository marcaRepo;

    @Inject
    private ModelVehiclesRepository modelRepo;

    @WebMethod
    public String crearVehicle(@WebParam(name = "brandId") Integer brandId,
                               @WebParam(name = "modelId") Integer modelId) {
        Vehicles v = new Vehicles();
        v.setBrandId(marcaRepo.findById(brandId));
        v.setModelId(modelRepo.findById(modelId));
        repo.save(v);
        return "Vehicle guardat!";
    }

    @WebMethod
    public List<Vehicles> llistarVehicles() {
        return repo.findAll();
    }

    @WebMethod
    public String eliminarVehicle(@WebParam(name = "id") Integer id) {
        return repo.delete(id) ? "Eliminat correctament" : "No s'ha trobat l'ID";
    }
}
