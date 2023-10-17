package com.example.spring.daytwo.model;

import com.example.spring.daytwo.tax.Taxable;

public abstract class SeniorDeveloper extends Developer {
    public SeniorDeveloper(int id, String name, double salary, Experience experience) {
        super(id, name, salary, experience);
    }


}
