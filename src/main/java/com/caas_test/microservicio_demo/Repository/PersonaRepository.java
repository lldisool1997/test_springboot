package com.caas_test.microservicio_demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caas_test.microservicio_demo.Entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query("SELECT p FROM Persona p WHERE p.firstName = :firstName")
    List<Persona> findByFirstName(@Param("firstName") String firstName);
    
    @Query(value = "SELECT * FROM SPRING_TEST_TABLA_PERSONA WHERE last_name = :lastName", nativeQuery = true)
    List<Persona> findByLastNameNativeQuery(@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM SPRING_TEST_TABLA_PERSONA WHERE id = :id", nativeQuery = true)
    Persona findById(@Param("id") String id);
}
