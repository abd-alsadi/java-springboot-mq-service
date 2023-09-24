// package com.core.mqservice.consumers;

// import javax.jms.Message;
// import javax.jms.MessageListener;
// import javax.jms.ObjectMessage;

// import org.springframework.jms.annotation.JmsListener;
// import org.springframework.stereotype.Component;

// import com.core.mqservice.models.MessageModel;

// import lombok.extern.slf4j.Slf4j;

// @Component
// @Slf4j
// public class MQConsumer2 implements MessageListener {
    
//     @Override
//     @JmsListener(destination = "mq-topic2")
//     public void onMessage(Message message) {
//         try{
//             ObjectMessage objectMessage = (ObjectMessage)message;
//            // Object obj = objectMessage.getObject();
//             Object aa = objectMessage.getBody(Object.class);
//           //  MessageModel msg = (MessageModel)obj;
//             //do additional processing
//           // log.info("Received Message: "+ msg.toString());
//         } catch(Exception e) {
//           log.error("Received Exception : "+ e);
//         }

//     }
    
// }