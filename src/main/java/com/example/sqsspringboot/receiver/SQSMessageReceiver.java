package com.example.sqsspringboot.receiver;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SQSMessageReceiver
{
    //This method gets the messages from the queue
    @SqsListener(value = "sqs-queue") //listens to our queue
    public void loadMessagesFromQueue(String loadedMessage)
    {
        //System.out.println("Queue Messages: " + loadedMessage);
        log.info("Queue Messages: " + loadedMessage);
    }
}
