package com.company;

public class SaveComputerToFile implements SaveInterface{
    @Override
    public void save(String path, Computer computer) {
        System.out.println("Saving file " + path + ", " + computer);
    }
}
