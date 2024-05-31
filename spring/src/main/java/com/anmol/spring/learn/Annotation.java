package com.anmol.spring.learn;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// Spring Framework will manage objects
@Component("ann")
@Scope("prototype")
public class Annotation {
    public Annotation() {
        System.out.println("Annotation Object Created");
    }
    public void show(){
        System.out.println("Showing");
    }
}
