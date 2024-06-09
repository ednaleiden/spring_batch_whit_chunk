package com.spring_batch_chunk.persistence;

import com.spring_batch_chunk.entities.Persona;
import org.springframework.data.repository.CrudRepository;

// INTERFAZ DE CAPA DE PERSISTENCIA
public interface IPersonaDAO extends CrudRepository<Persona, Long> {
}
