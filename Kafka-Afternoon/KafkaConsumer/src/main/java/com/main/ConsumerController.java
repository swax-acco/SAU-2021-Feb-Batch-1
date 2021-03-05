package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class ConsumerController {
	
	@Autowired
    private Gson gson;
 
    @KafkaListener(topics = { "demo" })
    public void getTopics(@RequestBody String orderDetails) {
        System.out.println("Kafka event: " + orderDetails);
        OrderDetail orderDetail = gson.fromJson(orderDetails, OrderDetail.class);
        System.out.println("orderDetails value: " + orderDetail.getName() + " " + orderDetail.getId());
    }

}
