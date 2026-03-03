package com.mycompany.crud.soap.ws;

import com.mycompany.crud.soap.model.MarcaVehicle;
import com.mycompany.crud.soap.repository.MarcaVehicleRepository;
import jakarta.inject.Inject;
import jakarta.jws.HandlerChain;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService(serviceName = "MarcaVehicleService")
@HandlerChain(file = "handler-chain.xml")
public class MarcaVehicleWebService {

    @Inject
    private MarcaVehicleRepository repo;

    @WebMethod
    public String crearMarca(@WebParam(name = "brandName") String brandName) {
        MarcaVehicle m = new MarcaVehicle();
        m.setBrandName(brandName);
        repo.save(m);
        return "Marca guardada!";
    }

    @WebMethod
    public List<MarcaVehicle> llistarMarques() {
        return repo.findAll();
    }

    @WebMethod
    public String eliminarMarca(@WebParam(name = "id") Integer id) {
        return repo.delete(id) ? "Eliminada correctament" : "No s'ha trobat l'ID";
    }
}
