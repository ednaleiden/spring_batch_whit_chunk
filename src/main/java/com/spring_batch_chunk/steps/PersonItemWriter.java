package com.spring_batch_chunk.steps;

import com.spring_batch_chunk.entities.Persona;
import com.spring_batch_chunk.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//manejo de logs
@Slf4j
@Component
public class PersonItemWriter implements ItemWriter<Persona> {

    @Autowired
    private IPersonService personService;
    @Override
    public void write(Chunk<? extends Persona> chunk) throws Exception {

        chunk.forEach(persona -> log.info(persona.toString()));

        personService.saveAll((List<Persona>) chunk.getItems());
    }
}
