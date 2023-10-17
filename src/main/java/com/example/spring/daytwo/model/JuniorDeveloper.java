package com.example.spring.daytwo.model;

import com.example.spring.daytwo.tax.Taxable;

public abstract class JuniorDeveloper extends Developer {
    public JuniorDeveloper(int id, String name, double salary, Experience experience) {
        super(id, name, salary, experience);
    }

}
