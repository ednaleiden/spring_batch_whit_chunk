package com.spring_batch_chunk.service;

import com.spring_batch_chunk.entities.Persona;
import com.spring_batch_chunk.persistence.IPersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonServiceImpl implements IPersonService{

    //inyectamos el Dao
    @Autowired
    private IPersonaDAO personaDAO;
    @Override
    public Iterable<Persona> saveAll(List<Persona> personaList) {
        return personaDAO.saveAll(personaList);
    }
}
