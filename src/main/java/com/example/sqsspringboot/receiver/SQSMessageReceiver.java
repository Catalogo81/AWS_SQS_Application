package com.example.sqsspringboot.receiver;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SQSMessageReceiver {
    //This method gets the messages from the queue
    @SqsListener(value = "sqs-queue",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS) //listens to our queue
    public void processMessage(String loadedMessage) {

        try{
            if (loadedMessage != null) {
                //System.out.println("Queue Messages: " + loadedMessage);
                log.info("Queue Messages: " + loadedMessage);
            }
        }catch (Exception e)
        {
            System.out.println("Error reading the SQS manager: " + e.getMessage());
        }
    }
}
