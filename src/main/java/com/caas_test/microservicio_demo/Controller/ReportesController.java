package com.caas_test.microservicio_demo.Controller;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caas_test.microservicio_demo.Entity.ReporteDTO;
import com.caas_test.microservicio_demo.Service.ReporteService;


@RestController
@RequestMapping("reporte")
public record ReportesController(ReporteService service) {

    @PostMapping("/reportes")
    public List<ReporteDTO> getReportes(@RequestParam int page, @RequestParam int size) {
        return service.getReporte(page, size);
    }
}
