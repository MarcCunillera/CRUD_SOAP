package com.mycompany.crud.soap.client;

import com.mycompany.crud.soap.client.stubs.MarcaVehicleService;
import com.mycompany.crud.soap.client.stubs.MarcaVehicleWebService;
import com.mycompany.crud.soap.client.stubs.MarcaVehicle;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.HandlerResolver;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.PortInfo;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author marccunillera
 */
public class MarcaVehicleClient {

    private static final String WSSE_NS
            = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final String USUARI = "admin";
    private static final String CONTRASENYA = "1234";

    public static void main(String[] args) {

        // Connectar al servei afegint el handler de seguretat
        MarcaVehicleService service = new MarcaVehicleService();
        service.setHandlerResolver(new HandlerResolver() {
            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo) {
                List<Handler> handlers = new ArrayList<>();
                handlers.add(new ClientSecurityHandler());
                return handlers;
            }
        });

        MarcaVehicleWebService port = service.getMarcaVehicleWebServicePort();

        System.out.println("=== CLIENT SOAP amb WS-Security ===\n");

        System.out.println("-- Creant marca 'Toyota'...");
        System.out.println("Resposta: " + port.crearMarca("Toyota"));

        System.out.println("\n-- Llistant marques...");
        List<MarcaVehicle> marques = port.llistarMarques();
        for (MarcaVehicle m : marques) {
            System.out.println("  ID: " + m.getId() + " | " + m.getBrandName());
        }

        if (!marques.isEmpty()) {
            Integer id = marques.get(0).getId();
            System.out.println("\n-- Eliminant marca ID " + id + "...");
            System.out.println("Resposta: " + port.eliminarMarca(id));
        }

        System.out.println("\n=== FI ===");
    }

    // Handler del client que afegeix la capçalera WS-Security a cada petició
    static class ClientSecurityHandler implements SOAPHandler<SOAPMessageContext> {

        @Override
        public boolean handleMessage(SOAPMessageContext context) {
            Boolean isOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            if (!isOutbound) {
                return true;
            }

            try {
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                if (header == null) {
                    header = envelope.addHeader();
                }

                SOAPElement security = header.addChildElement("Security", "wsse", WSSE_NS);
                SOAPElement token = security.addChildElement("UsernameToken", "wsse", WSSE_NS);
                token.addChildElement("Username", "wsse", WSSE_NS).setTextContent(USUARI);
                token.addChildElement("Password", "wsse", WSSE_NS).setTextContent(CONTRASENYA);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        public boolean handleFault(SOAPMessageContext c) {
            return true;
        }

        @Override
        public void close(MessageContext c) {
        }

        @Override
        public Set<QName> getHeaders() {
            return null;
        }
    }
}
