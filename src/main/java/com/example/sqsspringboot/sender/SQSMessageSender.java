package com.example.sqsspringboot.sender;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSMessageSender
{
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    //This method sends the messages to the queue
    @GetMapping("/put/{msg}")
    public void putMessagesToQueue(@PathVariable("msg") String sentMessage)
    {
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(sentMessage).build());
        System.out.println("Message sent to queue: " + sentMessage);
    }
}
