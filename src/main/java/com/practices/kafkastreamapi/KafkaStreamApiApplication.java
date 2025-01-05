package com.practices.kafkastreamapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafkaStreams
@SpringBootApplication
public class KafkaStreamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamApiApplication.class, args);
    }

}
