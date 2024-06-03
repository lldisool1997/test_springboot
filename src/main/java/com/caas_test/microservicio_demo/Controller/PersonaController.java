package com.caas_test.microservicio_demo.Controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.caas_test.microservicio_demo.Entity.Persona;
import com.caas_test.microservicio_demo.Request.PersonaRegistrationRequest;
import com.caas_test.microservicio_demo.Service.PersonaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("persona")
public record PersonaController(PersonaService service) {
    
    @PostMapping("/agregar")
    @ResponseBody
    public ResponseEntity<String> registrarPersona(@RequestBody PersonaRegistrationRequest  param) {
        service.registerCustomer(param);
        return ResponseEntity.status(HttpStatus.CREATED).body("Se ha registrado a la persona");
    }

    @GetMapping("/personas")
    public List<Persona> getAllPersonas() {
        return service.getPersonas();
    }

    @GetMapping("/persona/{id}")
    public Persona getPersona(@PathVariable("id") String id) {
        return service.buscarPorid(id);
    }
    
    @GetMapping("/info")
    public ResponseEntity<String> jsonTest() {
        String jsonPersona = "{\"nombre\": \"Juan\", \"edad\": 30}";
        return ResponseEntity.ok(jsonPersona);
    }
    
}
