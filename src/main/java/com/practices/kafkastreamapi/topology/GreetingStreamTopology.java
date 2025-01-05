package com.practices.kafkastreamapi.topology;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GreetingStreamTopology {
    public static final String GREETING_TOPIC = "greeting-topic";
    public static final String GREETING_UPPERCASE_TOPIC = "greeting-uppercase-topic";

    /*
        StreamsBuilder is a high-level Kafka Streams DSL that allows you to define your Kafka Streams topology.
        Automatically created by Spring Kafka Streams and injected into Spring Context.

        The process method is annotated with @Autowired, which means that Spring will automatically inject the StreamsBuilder instance into the method.
        This method is invoked automatically during Spring's bean lifecycle.
        initialize the Kafka Streams topology after the StreamsBuilder is ready.
        Can use @PostConstruct (Constructor Injection) instead of @Autowired.
    */
    @Autowired
    public void process(StreamsBuilder streamsBuilder) {
        log.info("Creating Greeting Stream Topology");

        KStream<String, String> stream = streamsBuilder.stream(
                GREETING_TOPIC,
                Consumed.with(Serdes.String(), Serdes.String())
        );
        stream.print(Printed.<String, String>toSysOut().withLabel("Greeting Stream"));

        KStream<String, String> modifiedStream = stream.mapValues((key, value) -> value.toUpperCase());
        modifiedStream.print(Printed.<String, String>toSysOut().withLabel("Modified Stream"));
        modifiedStream.to(GREETING_UPPERCASE_TOPIC, Produced.with(Serdes.String(), Serdes.String()));
    }
}
