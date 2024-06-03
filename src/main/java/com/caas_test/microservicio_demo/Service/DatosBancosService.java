package com.caas_test.microservicio_demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public record DatosBancosService(JdbcTemplate jdb) {

    public void consultaTest(){
        String consultaSQL = "SELECT numdoc FROM datos_personales where numdoc = ?";

        // Ejecutamos la consulta y obtenemos el resultado
        Object[] parametros = new Object[]{"70429350"}; // Parámetros de la consulta
        List<Map<String, Object>> resultado = jdb.queryForList(consultaSQL, parametros);

        // Procesamos el resultado de la consulta como desees
        StringBuilder resultadoFormateado = new StringBuilder();
        for (Map<String, Object> fila : resultado) {
            resultadoFormateado.append("Columna1: ").append(fila.get("numdoc")).append(", ");
        }
  
        System.out.println(resultadoFormateado.toString());
    }
}
