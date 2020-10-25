package com.hebertrfreitas.kafkalabs.serviceproducer.controller;


import com.hebertrfreitas.kafkalabs.serviceproducer.Message;
import com.hebertrfreitas.kafkalabs.serviceproducer.service.OrderProducerService;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("orders")
public class SendMessageController {


    private final OrderProducerService orderProducerService;

    public SendMessageController(OrderProducerService orderProducerService) {
        this.orderProducerService = orderProducerService;
    }

    @GetMapping
    public void get(){
        System.out.println("Chamou get");
    }


    @PostMapping
    public void postMessage(@RequestBody Message message){
        System.out.println(message);
        var listenableFuture = orderProducerService.sendMessage(message);
    }


}
