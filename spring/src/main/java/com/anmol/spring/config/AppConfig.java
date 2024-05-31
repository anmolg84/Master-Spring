package com.anmol.spring.config;

import com.anmol.spring.learn.Annotation;
import com.anmol.spring.learn.DependencyInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// @Configuration : To make this file Configuration File
@Configuration
// Scan And Manage all components inside mentioned package
@ComponentScan("com.anmol.spring.learn")
public class AppConfig {
    // @Bean : Definition of Bean in Java Based Configuration
    @Bean(name = {"ann","anotat"})
    @Scope("prototype") // Providing Prototype scope for Bean
    public Annotation annotation(){
        return new Annotation();
    }

    // @Autowired : Will Search and Wire for Annotation Class
    @Bean
    public DependencyInjection dependencyInjection(@Autowired Annotation annotation){
        return new DependencyInjection();
    }
}
