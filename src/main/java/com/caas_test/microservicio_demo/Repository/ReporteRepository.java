package com.caas_test.microservicio_demo.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.caas_test.microservicio_demo.Entity.ReporteDTO;

public interface ReporteRepository extends JpaRepository<ReporteDTO, String>{

    @Query(value = "SELECT A.ID_PERSONAL, A.NUMDOC AS NUMDOC FROM DATOS_PERSONALES A, VENT_REGISTRO B WHERE A.ID_PERSONAL = B.ID_PERSONAL",
           nativeQuery = true)
    List<ReporteDTO> obtenerResultadoConsulta(Pageable pageable); //Quiero hacer que tenga paginacion
    
}
