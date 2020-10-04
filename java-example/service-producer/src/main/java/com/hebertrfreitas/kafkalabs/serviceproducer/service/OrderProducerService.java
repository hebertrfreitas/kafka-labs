package com.hebertrfreitas.kafkalabs.serviceproducer.service;

import com.hebertrfreitas.kafkalabs.serviceproducer.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Service
public class OrderProducerService {


    @Value("${myproperty.topic}")
    private String topic;

    private final KafkaTemplate kafkaTemplate;

    public OrderProducerService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public ListenableFuture sendMessage(Message message){
        return kafkaTemplate.send(topic, UUID.randomUUID().toString(), message.toString());
    }

}
