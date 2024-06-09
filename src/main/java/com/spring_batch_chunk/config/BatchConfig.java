package com.spring_batch_chunk.config;


import com.spring_batch_chunk.entities.Persona;
import com.spring_batch_chunk.steps.PersonItemReader;
import com.spring_batch_chunk.steps.PersonItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing

public class BatchConfig {


    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public PersonItemReader itemReader() {
        return new PersonItemReader();
    }

    @Bean
    public PersonItemWriter itemWriter() {
        return new PersonItemWriter();
    }

    @Bean
    public Step readFile() {
        return new StepBuilder("readFile", jobRepository)
                .<Persona, Persona>chunk(10, transactionManager)
                .reader(itemReader())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public Job job() {
        return new JobBuilder("readFileWithChunk", jobRepository)
                .start(readFile())
                .build();
    }
}
