package com.practices.kafkastreamapi.config;

import com.practices.kafkastreamapi.topology.GreetingStreamTopology;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class GreetingStreamConfiguration {

    @Bean
    public NewTopic greetingTopic() {
        return TopicBuilder.name(GreetingStreamTopology.GREETING_TOPIC)
                .partitions(2)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic greetingUppercaseTopic() {
        return TopicBuilder.name(GreetingStreamTopology.GREETING_UPPERCASE_TOPIC)
                .partitions(2)
                .replicas(1)
                .build();
    }
}
