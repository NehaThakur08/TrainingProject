package com.neha.application;

import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public String phone;

    public Person(){

    }
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
