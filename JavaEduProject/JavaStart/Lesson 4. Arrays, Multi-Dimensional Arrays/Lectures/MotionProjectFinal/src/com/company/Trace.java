package com.company;

import javafx.scene.shape.Circle;

public class Trace extends Circle {
    private double x;
    private double y;

    public Trace(double x, double y) {
        super(1);
        this.x = x;
        this.y = y;
    }

    public void update() {
        setTranslateX(x * Constants.ZOOM + Constants.W / 2);
        setTranslateY(y * Constants.ZOOM + Constants.H / 2);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
