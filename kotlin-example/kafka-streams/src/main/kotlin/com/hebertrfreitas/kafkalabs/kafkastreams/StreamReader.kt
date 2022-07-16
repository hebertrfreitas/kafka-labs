package com.hebertrfreitas.kafkalabs.kafkastreams

import org.apache.kafka.streams.StreamsBuilder
import org.springframework.stereotype.Service

@Service
class StreamReader(val kStreamBuilder: StreamsBuilder) {


    fun execute(){

        println("Executing....")

        val stream = kStreamBuilder.stream<String, String>("streams-plaintext-input")
            .flatMapValues { key, value -> listOf(value.toUpperCase())   }
            .groupBy { key, value ->  value }
            .count()
            .toStream()
            .to("streams-wordcount-output")

    }
}





