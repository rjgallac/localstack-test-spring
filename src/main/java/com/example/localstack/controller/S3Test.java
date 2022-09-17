package com.example.localstack.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("s3")
public class S3Test {

    @Autowired
    private AmazonS3 amazonS3;



    @GetMapping
    public List<Bucket> get(){
        List<Bucket> buckets = amazonS3.listBuckets();
        return buckets;

    }

}
