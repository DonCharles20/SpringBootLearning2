package com.don;

public class Dev {
    //not instantiated
    private Computer comp;// this is a refrence no assigned object, use IOC to inject Laptop or Desktop dependecy

    private int age;
    private int testvalue;

    public Dev(){
        System.out.println("Dev Constrcutor");
    }

    public Dev(int age) {//this is used for constrcutor injection
        this.age = age;
        System.out.println("Dev Constrcutor injection");
    }
    public Dev(int age, int value) {//this is used for constrcutor injection with 2 parameters
        this.age = age;
        testvalue=value;
        System.out.println("Dev Constrcutor injection 2");
    }

    public Dev(Computer comp){//this is used for constrcutor injection with non primitave values
        this.comp=comp;
        System.out.println("Comp Constrcutor");
    }

    public void build(){
        System.out.println("Building the project");
        comp.compile();
    }

    //Eveything below is used for setter injection
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTestvalue() {
        return testvalue;
    }

    public void setTestvalue(int testvalue) {
        this.testvalue = testvalue;
    }

    //Setter names matter when refrenceing from spring.xml
    //the setter names must match varible names ie. int age: public int getAge(){return age;}
        
    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }
}
