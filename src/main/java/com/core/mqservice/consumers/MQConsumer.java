package com.core.mqservice.consumers;

import java.util.UUID;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.core.mqservice.models.*;

import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.core.mqservice.dao.MQDetailsDAO;
import com.core.mqservice.helpers.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Slf4j
public class MQConsumer implements MessageListener {

    @Autowired
    MQDetailsDAO DAO;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    @JmsListener(destination = "mq-topic")
    public void onMessage(Message message) {
        try{
       
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String strData = textMessage.getText();
                MQRequestModel data= mapper.readValue(strData,MQRequestModel.class);
                MQDetailsModel details = new MQDetailsModel();
                details.setRequestID(data.getId());
                details.setStatus("inprogress");
                DAO.Add(details);

                // processed

                details.setId(null);
                details.setStatus("done");
                DAO.Add(details);
                log.info("Received Message: "+ strData.toString());

            } else {
                System.out.println("Received: " + message);
            }
        } catch(Exception e) {
          log.error("Received Exception : "+ e);
        }
    }   
}