package com.kdnakt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class MyData {

    private int id;
    @ToString.Exclude
    private String name;
    private String location;

}