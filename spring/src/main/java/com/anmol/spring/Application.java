package com.anmol.spring;

import com.anmol.spring.config.AppConfig;
import com.anmol.spring.learn.Annotation;
import com.anmol.spring.learn.DependencyInjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// spring-context dependency
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @SpringBootApplication : Using SpringBoot
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		// Different ways to Configure spring : XML , JAVA , Annotations
		// XML Based Configuration : Beans are defined on XML configuration Files
		System.out.println("XML Based Configuration");
		ApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DependencyInjection diXml = (DependencyInjection) springContext.getBean("dependencyXml");
		// Avoid Type Casting : getBeanByType
		DependencyInjection diXml2 = springContext.getBean("dependencyXml", DependencyInjection.class);
		diXml.print();
		// Creating Context for Communication with IOC Container {Fetch Beans}
		// ApplicationContext = BeanFactory + features

		// Java Based Configuration
		System.out.println("Java Based Configuration");
		ApplicationContext javaContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Annotation diJava = javaContext.getBean("anotat",Annotation.class); // getting BeanByName
		diJava.show();

		// Annotation Based Configuration
		System.out.println("Annotation Based Configuration");
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Welcome To My Spring Application");
		// Requesting Bean from IOC
		DependencyInjection di = context.getBean(DependencyInjection.class);
		di.code();
	}
}
