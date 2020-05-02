package com.upc.curso.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.stereotype.Component;

@Component
public class JmsOyente {

    @Autowired
    private JmsTemplate jmsTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${jms.cola.respuesta}")
    String destinationQueue;


    @JmsListener(destination = "${jms.cola.envio}")
    public void miMensaje(String mensajeJson, JmsMessageHeaderAccessor headerAccessor) {
        LOGGER.debug("RENIEC: Recibido:" + mensajeJson);
        String corrId;
        corrId = headerAccessor.getCorrelationId();
        System.out.println("RENIEC: CorrID:" + corrId);
        String nuevoMensaje = "El DNI es válido " + mensajeJson + "!!!";
        System.out.println("RENIEC: Respondiendo: " + nuevoMensaje);
        jmsTemplate.convertAndSend(destinationQueue, nuevoMensaje, m -> {
            m.setJMSCorrelationID(corrId);
            return m;
        });
    }
}


