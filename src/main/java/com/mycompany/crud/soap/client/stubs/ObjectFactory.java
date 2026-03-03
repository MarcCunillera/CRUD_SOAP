
package com.mycompany.crud.soap.client.stubs;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.crud.soap.client.stubs package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrearMarca_QNAME = new QName("http://ws.soap.crud.mycompany.com/", "crearMarca");
    private final static QName _CrearMarcaResponse_QNAME = new QName("http://ws.soap.crud.mycompany.com/", "crearMarcaResponse");
    private final static QName _EliminarMarca_QNAME = new QName("http://ws.soap.crud.mycompany.com/", "eliminarMarca");
    private final static QName _EliminarMarcaResponse_QNAME = new QName("http://ws.soap.crud.mycompany.com/", "eliminarMarcaResponse");
    private final static QName _LlistarMarques_QNAME = new QName("http://ws.soap.crud.mycompany.com/", "llistarMarques");
    private final static QName _LlistarMarquesResponse_QNAME = new QName("http://ws.soap.crud.mycompany.com/", "llistarMarquesResponse");
    private final static QName _MarcaVehicle_QNAME = new QName("http://ws.soap.crud.mycompany.com/", "marcaVehicle");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.crud.soap.client.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrearMarca }
     * 
     */
    public CrearMarca createCrearMarca() {
        return new CrearMarca();
    }

    /**
     * Create an instance of {@link CrearMarcaResponse }
     * 
     */
    public CrearMarcaResponse createCrearMarcaResponse() {
        return new CrearMarcaResponse();
    }

    /**
     * Create an instance of {@link EliminarMarca }
     * 
     */
    public EliminarMarca createEliminarMarca() {
        return new EliminarMarca();
    }

    /**
     * Create an instance of {@link EliminarMarcaResponse }
     * 
     */
    public EliminarMarcaResponse createEliminarMarcaResponse() {
        return new EliminarMarcaResponse();
    }

    /**
     * Create an instance of {@link LlistarMarques }
     * 
     */
    public LlistarMarques createLlistarMarques() {
        return new LlistarMarques();
    }

    /**
     * Create an instance of {@link LlistarMarquesResponse }
     * 
     */
    public LlistarMarquesResponse createLlistarMarquesResponse() {
        return new LlistarMarquesResponse();
    }

    /**
     * Create an instance of {@link MarcaVehicle }
     * 
     */
    public MarcaVehicle createMarcaVehicle() {
        return new MarcaVehicle();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearMarca }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearMarca }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.crud.mycompany.com/", name = "crearMarca")
    public JAXBElement<CrearMarca> createCrearMarca(CrearMarca value) {
        return new JAXBElement<CrearMarca>(_CrearMarca_QNAME, CrearMarca.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearMarcaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearMarcaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.crud.mycompany.com/", name = "crearMarcaResponse")
    public JAXBElement<CrearMarcaResponse> createCrearMarcaResponse(CrearMarcaResponse value) {
        return new JAXBElement<CrearMarcaResponse>(_CrearMarcaResponse_QNAME, CrearMarcaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarMarca }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarMarca }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.crud.mycompany.com/", name = "eliminarMarca")
    public JAXBElement<EliminarMarca> createEliminarMarca(EliminarMarca value) {
        return new JAXBElement<EliminarMarca>(_EliminarMarca_QNAME, EliminarMarca.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarMarcaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarMarcaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.crud.mycompany.com/", name = "eliminarMarcaResponse")
    public JAXBElement<EliminarMarcaResponse> createEliminarMarcaResponse(EliminarMarcaResponse value) {
        return new JAXBElement<EliminarMarcaResponse>(_EliminarMarcaResponse_QNAME, EliminarMarcaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LlistarMarques }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LlistarMarques }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.crud.mycompany.com/", name = "llistarMarques")
    public JAXBElement<LlistarMarques> createLlistarMarques(LlistarMarques value) {
        return new JAXBElement<LlistarMarques>(_LlistarMarques_QNAME, LlistarMarques.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LlistarMarquesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LlistarMarquesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.crud.mycompany.com/", name = "llistarMarquesResponse")
    public JAXBElement<LlistarMarquesResponse> createLlistarMarquesResponse(LlistarMarquesResponse value) {
        return new JAXBElement<LlistarMarquesResponse>(_LlistarMarquesResponse_QNAME, LlistarMarquesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarcaVehicle }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MarcaVehicle }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soap.crud.mycompany.com/", name = "marcaVehicle")
    public JAXBElement<MarcaVehicle> createMarcaVehicle(MarcaVehicle value) {
        return new JAXBElement<MarcaVehicle>(_MarcaVehicle_QNAME, MarcaVehicle.class, null, value);
    }

}
