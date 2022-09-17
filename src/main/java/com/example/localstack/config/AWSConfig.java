package com.example.localstack.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {


    @Value("${amazon.s3.endpoint}")
    private String amazons3Endpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(
                amazonAWSAccessKey, amazonAWSSecretKey);
    }

    @Bean
    public AmazonS3 amazonS3() {
//        AmazonS3 s3client = AmazonS3ClientBuilder
//                .standard()
//                .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
//                .withRegion(Regions.US_EAST_1)
//                .build();
        AmazonS3 s3client = new AmazonS3Client(amazonAWSCredentials());
        s3client.setEndpoint(amazons3Endpoint);
        return s3client;
    }

    @Bean
    public AmazonSQS amazonSQS() {
        AmazonSQS amazonSQS = new AmazonSQSClient(amazonAWSCredentials());

        amazonSQS.setEndpoint(amazons3Endpoint);
        return amazonSQS;
    }


}
