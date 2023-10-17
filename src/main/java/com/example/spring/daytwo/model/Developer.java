package com.example.spring.daytwo.model;

public class Developer {
    private int id;
    private String name;
    private double salary;
    private Experience experience;

    public Developer(int id, String name, double salary, Experience experience) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

}
