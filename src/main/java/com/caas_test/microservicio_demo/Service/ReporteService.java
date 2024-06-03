package com.caas_test.microservicio_demo.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.caas_test.microservicio_demo.Entity.ReporteDTO;
import com.caas_test.microservicio_demo.Repository.ReporteRepository;

@Service
public record ReporteService(ReporteRepository repositorio) {
    
    public List<ReporteDTO> getReporte(int pagina, int tamanoPagina){
        Pageable pageable = PageRequest.of(pagina, tamanoPagina);
        return repositorio.obtenerResultadoConsulta(pageable);
    }
}
