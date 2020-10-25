package com.kdnakt.dynamodb;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;

public class App {

    public static void main(String[] args) {
        String id = "3";
        AmazonDynamoDB dynamodb = AmazonDynamoDBClientBuilder.defaultClient();
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("id", new AttributeValue(id));
        GetItemRequest req = new GetItemRequest()
                .withTableName("sample")
                .withKey(key);
        Map<String, AttributeValue> item = dynamodb.getItem(req).getItem();
        System.out.println("id: " + id);
        System.out.println("attr_s getS(): " + item.get("attr_s").getS());
        System.out.println("attr_s getN(): " + item.get("attr_s").getN());
        System.out.println("attr_n getS(): " + item.get("attr_n").getS());
        System.out.println("attr_n getN(): " + item.get("attr_n").getN());
    }

}
