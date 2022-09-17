package com.example.localstack.controller;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("sqs")
public class SQSTest {

    @Autowired
    private AmazonSQS amazonSQS;

    @GetMapping
    public List<String> list(){
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest();
        receiveMessageRequest.setQueueUrl("http://localhost:4566/000000000000/test-queue");
        ReceiveMessageResult receiveMessageResult = amazonSQS.receiveMessage(receiveMessageRequest);
        List<Message> messages = receiveMessageResult.getMessages();
        return messages.stream().map(message -> message.getBody()).collect(Collectors.toList());
    }

    @GetMapping("list-queues")
    public ListQueuesResult listQueues(){
        return amazonSQS.listQueues();
    }

    @PostMapping
    public void add(){
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.setQueueUrl("http://localhost:4566/000000000000/test-queue");
        sendMessageRequest.setMessageBody("test");
        amazonSQS.sendMessage(sendMessageRequest);
    }
}
