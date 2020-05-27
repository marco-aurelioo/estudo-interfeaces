package com.tio.interfaces.domain;

public class Vehicle {
    private String model;

    public  Vehicle(){
    }

    public  Vehicle(String model){
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
