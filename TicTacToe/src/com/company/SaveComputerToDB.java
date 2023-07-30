package com.company;

public class SaveComputerToDB implements SaveInterface{
    @Override
    public void save(String path, Computer computer){
        System.out.println("Saving to database " + path + ", " + computer);
    }
}
