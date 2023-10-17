package com.example.spring.daytwo.rest;


import com.example.spring.daytwo.model.Developer;
import com.example.spring.daytwo.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/developers")
public class DeveloperController {
    private Map<Integer, Developer> developers;
    private Taxable developerTaxJunior;
    private Taxable developerTaxMid;
    private Taxable developerTaxSenior;


    @Autowired
    public DeveloperController(@Qualifier("juniorDeveloper") Taxable developerTaxJunior,
                               @Qualifier("midDeveloper") Taxable developerTaxMid,
                               @Qualifier("seniorDeveloper") Taxable developerTaxSenior) {
        this.developerTaxJunior = developerTaxJunior;
        this.developerTaxMid = developerTaxMid;
        this.developerTaxSenior = developerTaxSenior;
    }

    @PostConstruct
    public void init() {
        System.out.println("Developers map created");
        developers = new HashMap<>();
    }

    public Map<Integer, Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Map<Integer, Developer> developers) {
        this.developers = developers;
    }


}
