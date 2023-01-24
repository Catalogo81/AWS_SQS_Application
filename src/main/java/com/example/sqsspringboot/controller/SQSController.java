//package com.example.sqsspringboot.controller;
//
//import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
//import io.awspring.cloud.messaging.listener.annotation.SqsListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import static java.rmi.server.LogStream.log;
//
//@RestController
//public class SQSController {
//
////    @Autowired
////    private QueueMessagingTemplate queueMessagingTemplate;
////
////    @Value("${cloud.aws.end-point.uri}")
////    private String endPoint;
////
////    //This method sends the messages to the queue
////    @GetMapping("/put/{msg}")
////    public void putMessagesToQueue(@PathVariable("msg") String sentMessage)
////    {
////        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(sentMessage).build());
////        System.out.println("Message sent to queue: " + sentMessage);
////    }
//
////    //This method gets the messages from the queue
////    @SqsListener(value = "sqs-queue") //listens to our queue
////    public void loadMessagesFromQueue(String loadedMessage)
////    {
////        //System.out.println("Queue Messages: " + loadedMessage);
////        log.info("Queue Messages: " + loadedMessage);
////    }
//
//}
