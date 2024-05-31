package com.anmol.spring.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// Component Annotation : Spring Framework : Object/Bean Creation in IOC
@Component("dependencyInjection")
public class DependencyInjection {
    private String name;
    // Explicitly providing Value
    @Value("23")
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public DependencyInjection() {
        System.out.println("DependencyInjection Object Created");
    }
    public DependencyInjection(int age){
        System.out.println("Parameterized Constructor called");
        this.age=age;
    }
    // Autowired Annotation : Wire Objects with original Class
    @Autowired
    @Qualifier("ann") // Reference to Bean named ann
    Annotation annotation;
    public void code(){
        annotation.show();
        System.out.println("Spring Framework Learning with " + getName());
    }
    public void print(){
        System.out.println("Spring Printing with " + getName());
    }
}
