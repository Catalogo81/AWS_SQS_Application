package com.example.sqsspringboot.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AmazonSQSConfiguration
{

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;


    //Queue messaging template
    @Bean
    public QueueMessagingTemplate queueMessagingTemplate()
    {
        //gets the QueueMessaging template
        return new QueueMessagingTemplate(buildAmazonSQSAsync());
    }

    @Bean
    @Primary
    public AmazonSQSAsync buildAmazonSQSAsync() {

        //returns the Amazon SQS Async queue object
        return AmazonSQSAsyncClientBuilder
                .standard()
                .withRegion("us_east_1"/*Regions.US_EAST_1*/)
                .withCredentials(
                        new AWSStaticCredentialsProvider(
                                new BasicAWSCredentials(accessKey, secretKey)
                        )
                )
                .build();
    }
}
