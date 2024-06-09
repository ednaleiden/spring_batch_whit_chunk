package com.spring_batch_chunk.service;

import com.spring_batch_chunk.entities.Persona;

import java.util.List;

public interface IPersonService {

     Iterable<Persona> saveAll(List<Persona> personaList);
}
