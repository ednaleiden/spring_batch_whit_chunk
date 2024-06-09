package com.spring_batch_chunk.config;

import com.spring_batch_chunk.steps.PersonItemReader;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Bean
    public PersonItemReader itemReader(){
        return new PersonItemReader();
    }
}
