package com.upc.curso.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upc.curso.jms.JmsProducerConsumer;

@RestController
@RequestMapping("/api")
public class JmsRest {
    @Autowired
    private JmsProducerConsumer jmsProducer;

    @GetMapping("/enviar/{mensaje}")
    public String enviar(@PathVariable(value = "mensaje") String mensaje) {
        jmsProducer.enviarRecibir(mensaje);
        return "OK!";
    }

}
