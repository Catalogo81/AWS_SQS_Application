package com.example.sqsspringboot.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@Slf4j
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
//        if(queueMessagingTemplate == null || sentMessage == null)
//        {
//            throw new RuntimeException();
//        }
//        else
//        {
            log.info("Sending Message to SQS ");
            queueMessagingTemplate.convertAndSend(endPoint,sentMessage);
            System.out.println("Message sent to queue: " + sentMessage);

        //}
    }
}
