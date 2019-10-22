package com.kdnakt.sandbox.jackson.databind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ObjectMapperSample {

    public static void main(final String[] args) {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectWriter writer = mapper.writer();

        final Person jack = new Person("Jack", 20);
        try {
            final String value = writer.writeValueAsString(jack);
            System.out.println(value);// {"name":"Jack","age":20}
            final Person result = mapper.readValue(value, Person.class);
            System.out.println(result);// Name:Jack, Age:20
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
