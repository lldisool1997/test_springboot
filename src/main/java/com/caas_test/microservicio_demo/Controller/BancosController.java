package com.caas_test.microservicio_demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caas_test.microservicio_demo.Entity.Persona;
import com.caas_test.microservicio_demo.Service.DatosBancosService;

@RestController
@RequestMapping("bancos")
public record BancosController(DatosBancosService service) {

    @GetMapping("/test")
    public void getAllPersonas() {
        service.consultaTest();
    }
    
}
