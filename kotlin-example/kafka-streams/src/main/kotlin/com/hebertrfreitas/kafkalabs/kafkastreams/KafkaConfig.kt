package com.hebertrfreitas.kafkalabs.kafkastreams

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.*
import org.apache.kafka.streams.processor.WallclockTimestampExtractor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration
import org.springframework.kafka.config.KafkaStreamsConfiguration
import org.springframework.kafka.config.StreamsBuilderFactoryBean
import org.springframework.kafka.config.StreamsBuilderFactoryBeanConfigurer
import java.time.Duration
import java.util.*
import kotlin.collections.HashMap


@Configuration
@EnableKafka
@EnableKafkaStreams
class KafkaConfig {

    @Bean(name = [KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME])
    fun kStreamsConfig() : KafkaStreamsConfiguration{
        val props : MutableMap<String, Any> = HashMap()
        props[StreamsConfig.APPLICATION_ID_CONFIG] = "testStreams"
        props[StreamsConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        props[StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG] = Serdes.String().javaClass.getName()
        props[StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG] = Serdes.String().javaClass.getName()
        props[StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG] = WallclockTimestampExtractor::class.java.getName()
        return KafkaStreamsConfiguration(props)
    }

    @Bean
    fun configurer(): StreamsBuilderFactoryBeanConfigurer? {
        return StreamsBuilderFactoryBeanConfigurer { fb: StreamsBuilderFactoryBean ->
            fb.setStateListener { newState: KafkaStreams.State, oldState: KafkaStreams.State ->
                println(
                    "State transition from $oldState to $newState"
                )
            }
        }
    }


    @Bean
    fun kStream(kStreamBuilder: StreamsBuilder): KStream<String, String>? {
//        val stream = kStreamBuilder.stream<String, String>("streams-plaintext-input")
//        stream
//            .mapValues(ValueMapper { obj: String -> obj.toUpperCase() } as ValueMapper<String, String>)
//            .groupByKey()
//            .windowedBy(TimeWindows.of(Duration.ofMillis(1000)))
//            .reduce(
//                { value1: String, value2: String -> value1 + value2 },
//                Named.`as`("windowStore")
//            )
//            .toStream()
//            .map{windowedId, value -> KeyValue(windowedId.key(), value)}
//            .filter { key, value -> value.length > 40  }
//            .to("streams-wordcount-output");
//
//        stream.print(Printed.toSysOut())


        val stream = kStreamBuilder.stream<String, String>("streams-plaintext-input")

            stream.flatMapValues { key, value -> listOf(value.toUpperCase())   }
            .groupBy { key, value ->  value }
            .count()
            .toStream()
            .to("streams-wordcount-output")


        return stream
    }


}