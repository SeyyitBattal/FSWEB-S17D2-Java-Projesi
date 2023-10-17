package com.example.spring.daytwo.model;

import com.example.spring.daytwo.tax.Taxable;

public abstract class MidDeveloper extends Developer  {
    public MidDeveloper(int id, String name, double salary, Experience experience) {
        super(id, name, salary, experience);
    }

}
