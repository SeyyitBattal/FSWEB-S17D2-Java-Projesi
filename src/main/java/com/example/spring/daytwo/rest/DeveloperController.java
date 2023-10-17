package com.example.spring.daytwo.rest;


import com.example.spring.daytwo.model.Developer;
import com.example.spring.daytwo.model.JuniorDeveloper;
import com.example.spring.daytwo.model.MidDeveloper;
import com.example.spring.daytwo.model.SeniorDeveloper;
import com.example.spring.daytwo.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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


    @GetMapping("/")
    public List<Developer> allDevelopers() {
        System.out.println("Get all developers");
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer findDevelopers(@PathVariable int id) {
        return developers.get(id);
    }

    @PostMapping("/")
    public String addDeveloper(@RequestBody Developer developer) {

        switch (developer.getExperience()) {
            case JUNIOR:
                developer = new JuniorDeveloper(developer.getId(), developer.getName(), developer.getSalary(), developer.getExperience());
                developer.setSalary(developer.getSalary() - developerTaxJunior.getSimpleTaxRate());
                developers.put(developer.getId(), developer);
                break;
            case MID:
                developer = new MidDeveloper(developer.getId(), developer.getName(), developer.getSalary(), developer.getExperience()) {
                };
                developer.setSalary(developer.getSalary() - developerTaxMid.getMiddleTaxRate());
                developers.put(developer.getId(), developer);
                break;
            case SENIOR:
                developer = new SeniorDeveloper(developer.getId(), developer.getName(), developer.getSalary(), developer.getExperience()) {
                };
                developer.setSalary(developer.getSalary() - developerTaxSenior.getUpperTaxRate());
                developers.put(developer.getId(), developer);
                break;
        }
        return "Developer added successfully";
    }

    @PutMapping("/{id}")
    public String updateDeveloper(@PathVariable int id, @RequestBody Developer updatedDeveloper) {
        if (developers.containsKey(id)) {
            Developer developer = developers.get(id);
            developer.setName(updatedDeveloper.getName());
            developer.setSalary(updatedDeveloper.getSalary());
            developer.setExperience(updatedDeveloper.getExperience());
            developers.put(id, developer);
            return "Developer with id " + id + " updated successfully";
        } else {
            return "Developer with id " + id + " not found";
        }
    }

    @DeleteMapping("/{id}")
    public Developer deleteDeveloper(@PathVariable int id) {
        return developers.remove(id);
    }


}
