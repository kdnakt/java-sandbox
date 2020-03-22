package com.kdnakt.sandbox.jackson.databind;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ObjectMapperWithSet {

    public static void main(final String[] args) {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer();

        final Set<String> data = new HashSet<>();
        data.add("Hard Rock");
        data.add("Heavy Metal");
        try {
            final String value = writer.writeValueAsString(data);
            System.out.println(value);// ["Heavy Metal","Hard Rock"]
            @SuppressWarnings("unchecked")
            final Set<String> result = mapper.readValue(value, Set.class);
            System.out.println(result);// [Heavy Metal, Hard Rock]
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            final String value = writer.writeValueAsString(data);
            System.out.println(value);// ["Heavy Metal","Hard Rock"]
            final JavaType type = writer.getTypeFactory().constructCollectionType(Set.class, String.class);
            final Set<String> result = mapper.readValue(value, type);
            System.out.println(result);// [Heavy Metal, Hard Rock]
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            final String value = writer.writeValueAsString(data);
            System.out.println(value);// ["Heavy Metal","Hard Rock"]
            final Set<String> result = mapper.readValue(value, new TypeReference<Set<String>>() {
            });
            System.out.println(result);// [Heavy Metal, Hard Rock]
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
