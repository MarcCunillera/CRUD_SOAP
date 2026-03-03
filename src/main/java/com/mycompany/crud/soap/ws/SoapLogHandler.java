package com.mycompany.crud.soap.ws;

import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;
import javax.xml.namespace.QName;

public class SoapLogHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        try {
            context.getMessage().writeTo(System.out);
            System.out.println("\nMissatge SOAP processat correctament.");
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
