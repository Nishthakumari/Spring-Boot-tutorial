package com.annotations;

public class Student {

    private String name;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student (String name){
        this.name= name;
    }

    public void studying(){
        System.out.println(this.name+ "  I am studying");
    }
}
