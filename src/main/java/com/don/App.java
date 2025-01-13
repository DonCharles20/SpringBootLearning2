package com.don;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");//creating spring container
        System.out.println("");
        //is needed for spring to manage objects

        //Dev obj = new Dev();//creating object of Dev class manually and not in IOC
        //obj.build(); System.out.println("");
        //creating object of Dev class using spring container
        Dev obj1 = (Dev) context.getBean("setterDev");
        /*The method getBean("dev") is called on the context object to fetch a bean with the identifier "dev". 
        In Spring, beans are typically defined in configuration files (like XML) or annotated classes.
        The string "dev" is the name or ID of the bean that you want to retrieve.
        The retrieved bean is then cast to the Dev type. This cast is necessary because the getBean method returns an Object type, 
        and you need to cast it to the specific type you are expecting. 
        In this case, the expected type is Dev*/

        //this is being refrecned from spring.xml through setter injection with primitve value
        System.out.println("SetterDev Age: " + obj1.getAge());
        obj1.build();
        System.out.println("using setter injection with primative value \n");

        //this is being refrecned from spring.xml through constructor injection with 1 parameter
        Dev obj2 = (Dev) context.getBean("constructorDev");
        System.out.println("constructorDev Age: " + obj2.getAge());
        System.out.println("using constructor injection \n");

        //this is being refrecned from spring.xml through constructor injection with 2 parameters
        Dev obj3 = (Dev) context.getBean("constructorDev2");
        System.out.println("constructorDev2 Age: " + obj3.getAge() + " value: " + obj3.getTestvalue());
        System.out.println("using constructor injection with 2 parameters \n");

        //this is being refrecned from spring.xml through setter injection with non primitve value
        Dev laptopDev = (Dev) context.getBean("laptopDev");
        laptopDev.build();
        System.out.println("using setter injection with nonprimitve value \n");
        
        //this is being refrecned from spring.xml through autowire byName
        Dev compDevName = (Dev) context.getBean("compDevName");
        compDevName.build();
        System.out.println("using autowire byName \n");
        
        //this is being refrecned from spring.xml through autowire byType
        Dev compDevType = (Dev) context.getBean("compDevType");
        compDevType.build();
        System.out.println("using autowire byType \n");

        //this is being refrecned from spring.xml through constructor injection
        Dev compDevConstructor = (Dev) context.getBean("compDevConstructor");
        compDevConstructor.build();
        System.out.println("using constructor injection \n");

        //this is being refrecned from spring.xml but using the class as refrence
        //but if there are multipe beans of the same class then it will throw an error
        Dev DevClass = context.getBean("thisBean",Dev.class);
        DevClass.build();
        System.out.println("using class as refrence \n");

    }

}
