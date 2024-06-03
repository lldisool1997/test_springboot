package com.caas_test.microservicio_demo.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.caas_test.microservicio_demo.Entity.Persona;
import com.caas_test.microservicio_demo.Repository.PersonaRepository;
import com.caas_test.microservicio_demo.Request.PersonaRegistrationRequest;

@Service
public record PersonaService(PersonaRepository repository) {

    public void registerCustomer(PersonaRegistrationRequest req) {
        Persona customer = Persona.builder()
                .firstName(req.firstName())
                .lastName(req.lastName())
                .email(req.email())
                .build();
        this.repository.saveAndFlush(customer);
    }

    public List<Persona> getPersonas(){
        return repository.findAll();
    }

    public Persona buscarPorid(String id){
        return repository.findById(id);
    }
}

