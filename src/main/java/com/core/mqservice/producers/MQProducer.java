package com.core.mqservice.producers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.core.mqservice.models.MQRequestModel;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MQProducer {
    @Autowired
    JmsTemplate jmsTemplate;

     ObjectMapper mapper = new ObjectMapper();

    public void sendMessage(MQRequestModel message,String topic){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            String jsonData= mapper.writeValueAsString(message);
            jmsTemplate.convertAndSend(topic,jsonData);
        } catch(Exception e){
           log.error("Recieved Exception during send Message: ", e);
        }
    }
}