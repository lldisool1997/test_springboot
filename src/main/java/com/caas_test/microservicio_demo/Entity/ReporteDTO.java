package com.caas_test.microservicio_demo.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ReporteDTO {
    @Id
    private String ID_PERSONAL;
    private String NUMDOC;
}
