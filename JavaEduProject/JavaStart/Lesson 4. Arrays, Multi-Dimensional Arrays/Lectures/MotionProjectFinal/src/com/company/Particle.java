package com.company;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Particle extends Circle {
    private String name;
    private double mass;
    private Velocity velocity;
    private double x;
    private double y;

    public Particle(String name, double mass, double x, double y) {
        super(10, Color.color(Math.random(), Math.random(), Math.random()));
        this.name = name;
        this.mass = mass;
        velocity = new Velocity();
        this.x = x;
        this.y = y;
    }

    public void update() {
        x += velocity.getxComp() * Constants.SPEED;
        y += velocity.getyComp() * Constants.SPEED;
        setTranslateX(x * Constants.ZOOM + Constants.W / 2);
        setTranslateY(y * Constants.ZOOM + Constants.H / 2);
    }   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
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

    @Override
    public String toString() {
        return String.format("Particle{name = %s, x = %f, y = %f}", name, getCenterX() + getTranslateX(), getCenterY() + getTranslateY());
    }
}
