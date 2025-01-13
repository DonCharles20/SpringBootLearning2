package com.don;

public class Laptop implements Computer {

    public Laptop(){
        System.out.println("Laptop Constrcutor");
    }

    @Override
    public void compile(){
        System.out.println("Compling in Laptop");
    }
}
