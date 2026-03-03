package com.mycompany.crud.soap.ws;

import jakarta.xml.soap.*;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import jakarta.xml.ws.soap.SOAPFaultException;
import javax.xml.namespace.QName;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author marccunillera
 */
public class SecurityHandler implements SOAPHandler<SOAPMessageContext> {

    private static final String USUARI_VALID = "admin";
    private static final String CONTRASENYA_VALIDA = "1234";
    private static final String WSSE_NS
            = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (isOutbound) {
            return true;
        }

        try {
            SOAPHeader header = context.getMessage().getSOAPHeader();
            if (header == null) {
                throwFault("No s'ha proporcionat capçalera de seguretat");
            }

            SOAPElement security = getChild(header, "Security");
            if (security == null) {
                throwFault("No s'ha trobat l'element Security");
            }

            SOAPElement token = getChild(security, "UsernameToken");
            if (token == null) {
                throwFault("No s'ha trobat UsernameToken");
            }

            String username = getChild(token, "Username").getTextContent();
            String password = getChild(token, "Password").getTextContent();

            if (!USUARI_VALID.equals(username) || !CONTRASENYA_VALIDA.equals(password)) {
                throwFault("Credencials incorrectes");
            }

            System.out.println("[Security] Usuari autenticat: " + username);

        } catch (SOAPFaultException e) {
            throw e;
        } catch (Exception e) {
            throwFault("Error de seguretat: " + e.getMessage());
        }
        return true;
    }

    private SOAPElement getChild(SOAPElement parent, String localName) {
        Iterator<?> it = parent.getChildElements(new QName(WSSE_NS, localName));
        return it.hasNext() ? (SOAPElement) it.next() : null;
    }

    private void throwFault(String message) {
        try {
            SOAPFault fault = SOAPFactory.newInstance().createFault();
            fault.setFaultString("Accés denegat: " + message);
            throw new SOAPFaultException(fault);
        } catch (SOAPException e) {
            throw new RuntimeException(message);
        }
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
