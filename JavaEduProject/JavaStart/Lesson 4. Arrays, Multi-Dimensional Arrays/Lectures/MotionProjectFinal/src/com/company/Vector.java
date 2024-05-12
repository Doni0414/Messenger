package com.company;

public abstract class Vector {
    protected double xComp;
    protected double yComp;

    public Vector() {

    }

    public Vector(double xComp, double yComp) {
        this.xComp = xComp;
        this.yComp = yComp;
    }

    public double getxComp() {
        return xComp;
    }

    public void setxComp(double xComp) {
        this.xComp = xComp;
    }

    public double getyComp() {
        return yComp;
    }

    public void setyComp(double yComp) {
        this.yComp = yComp;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "xComp=" + xComp +
                ", yComp=" + yComp +
                '}';
    }
}
