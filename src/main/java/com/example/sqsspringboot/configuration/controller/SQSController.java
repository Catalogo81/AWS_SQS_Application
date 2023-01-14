package com.example.sqsspringboot.configuration.controller;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    //This method sends the messages to the queue
    @GetMapping("/put/{msg}")
    public void putMessagesToQueue(@PathVariable("msg") String message)
    {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(message).build());
    }

    //This method gets the messages from the queue
    @SqsListener("sqs-queue") //listens to our queue
    public void loadMessagesFromQueue(String message)
    {
        System.out.println("Queue Messages: " + message);
    }
}
