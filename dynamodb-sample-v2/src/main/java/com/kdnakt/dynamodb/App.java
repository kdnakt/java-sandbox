package com.kdnakt.dynamodb;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        String id = "3";
        DynamoDbClient dynamodb = DynamoDbClient.builder().build();
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("id", AttributeValue.builder().s(id).build());
        GetItemRequest req = GetItemRequest.builder()
                .tableName("sample")
                .key(key)
                .build();
        Map<String, AttributeValue> item = dynamodb.getItem(req).item();
        System.out.println("id: " + id);
        System.out.println("attr_s s(): " + item.get("attr_s").s());
        System.out.println("attr_s n(): " + item.get("attr_s").n());
        System.out.println("attr_n s(): " + item.get("attr_n").s());
        System.out.println("attr_n n(): " + item.get("attr_n").n());
    }

}
