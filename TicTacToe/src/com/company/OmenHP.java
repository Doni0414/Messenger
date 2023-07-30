package com.company;

public class OmenHP extends Computer{
    public OmenHP(String name, int memorySize){
        super(name, memorySize);
    }

    public void setData(String name){
        this.name = name;
        this.memorySize = 8000;
    }
}
