package com.spring_batch_chunk.steps;

import com.spring_batch_chunk.entities.Persona;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

public class PersonItemReader extends FlatFileItemReader<Persona> {

    //creamos constructor
    public PersonItemReader() {
        //seteamos las propiedades a nuestro FlatFileItemReader
        setName("readPersons");
        setResource(new ClassPathResource("persons.csv"));
        setLinesToSkip(1);//lineas a saltar para la lectura
        setEncoding(StandardCharsets.UTF_8.name());
        setLineMapper(getLineMapper());
    }

    public LineMapper<Persona> getLineMapper() {
       DefaultLineMapper<Persona> mapper = new DefaultLineMapper<>();
       DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

       String[] columns = new String[] {"name","lastName","age"};
       int[] indexFields = new int[] {0,1,2};

        lineTokenizer.setNames(columns);
        lineTokenizer.setIncludedFields(indexFields);
        lineTokenizer.setDelimiter(","); //seárador

        //mapea las columnas con objeto tipo persona
        BeanWrapperFieldSetMapper<Persona> fieldSetMapper = new BeanWrapperFieldSetMapper<Persona>();
        fieldSetMapper.setTargetType(Persona.class);

        mapper.setLineTokenizer(lineTokenizer);
        mapper.setFieldSetMapper(fieldSetMapper);

        return mapper;
    }
}

