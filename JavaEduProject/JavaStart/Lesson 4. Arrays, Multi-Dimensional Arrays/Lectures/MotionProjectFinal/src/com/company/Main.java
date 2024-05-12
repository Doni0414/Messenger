package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Simulation simulation = getSimulation3();
        simulation.start();
        Scene scene = new Scene(simulation);
        stage.setTitle("Particle Motion");
        stage.setScene(scene);
        stage.show();
    }

    public static Simulation getSimulation1() {
        Simulation simulation = new Simulation();

        Particle sun = new Particle("Sun", 1.989e30, 0, 0);
        sun.setVelocity(new Velocity(0, 0));
        sun.setRadius(20);
        sun.setFill(Color.YELLOW);
        simulation.addParticle(sun);

        Particle earth = new Particle("Earth", 5.9742e24, -1 * Constants.AU, 0);
        earth.setVelocity(new Velocity(0,  29.765e3));
        earth.setFill(Color.BLUE);
        simulation.addParticle(earth);

        Particle moon = new Particle("Moon", 7.36e22, -(1 + 0.00257) * Constants.AU, 0);
        moon.setRadius(5);
        moon.setFill(Color.WHITE);
        moon.setVelocity(new Velocity(0, earth.getVelocity().yComp + 1.023e3));
        simulation.addParticle(moon);

        return simulation;
    }

    public static Simulation getSimulation2() {
        Simulation simulation = new Simulation();

        Particle sun = new Particle("Sun", 1.989e30, 0, 0);
        sun.setVelocity(new Velocity(230e3, 0));
        sun.setRadius(20);
        sun.setFill(Color.YELLOW);
        simulation.addParticle(sun);

        Particle earth = new Particle("Earth", 5.9742e24, -1 * Constants.AU, 0);
        earth.setVelocity(new Velocity(sun.getVelocity().xComp,  29.765e3));
        earth.setFill(Color.BLUE);
        simulation.addParticle(earth);

        Particle moon = new Particle("Moon", 7.36e22, -(1 + 0.00257) * Constants.AU, 0);
        moon.setRadius(5);
        moon.setFill(Color.WHITE);
        moon.setVelocity(new Velocity(earth.getVelocity().xComp, earth.getVelocity().yComp + 1.023e3));
        simulation.addParticle(moon);

        return simulation;
    }

    public static Simulation getSimulation3() {
        var simulation = new Simulation();

        var sun = new Particle("Sun", 1.989e30, 0, 0);
        sun.setRadius(20);
        sun.setFill(Color.YELLOW);
        simulation.addParticle(sun);

        var mercury = new Particle("Mercury", 3.285e23, -0.387 * Constants.AU, 0);
        mercury.setVelocity(new Velocity(0, -48e3));
        mercury.setFill(Color.ROSYBROWN);
        simulation.addParticle(mercury);

        var venus = new Particle("Venus", 4.867e24, -0.723 * Constants.AU, 0);
        venus.setVelocity(new Velocity(0, 35e3));
        venus.setFill(Color.WHEAT);
        simulation.addParticle(venus);

        var earth = new Particle("Earth", 5.9742e24, -1 * Constants.AU, 0);
        earth.setVelocity(new Velocity(0,  29.765e3));
        earth.setFill(Color.BLUE);
        simulation.addParticle(earth);

        var mars = new Particle("Mars", 6.39e23, -1.52 * Constants.AU, 0);
        mars.setVelocity(new Velocity(0, -24.13e3));
        mars.setFill(Color.RED);
        simulation.addParticle(mars);

        var jupiter = new Particle("Jupiter", 1.898e27, -5.2 * Constants.AU, 0);
        jupiter.setVelocity(new Velocity(0, 13.07e3));
        jupiter.setFill(Color.BROWN);
        simulation.addParticle(jupiter);

        var saturn = new Particle("Saturn", 5.683e26, -9.58 * Constants.AU, 0);
        saturn.setVelocity(new Velocity(0, -9.69e3));
        saturn.setFill(Color.WHITESMOKE);
        simulation.addParticle(saturn);

        var uran = new Particle("Uran", 8.6849e25, -19.1914 * Constants.AU, 0);
        uran.setVelocity(new Velocity(0, 6.81e3));
        uran.setFill(Color.AQUA);
        simulation.addParticle(uran);

        var neptun = new Particle("Neptun", 1.024e26, -30.1 * Constants.AU, 0);
        neptun.setVelocity(new Velocity(0, -5.4349e3));
        neptun.setFill(Color.DARKBLUE);
        simulation.addParticle(neptun);

        var pluton = new Particle("Pluton", 1.31e22, -39.482 * Constants.AU, 0);
        pluton.setVelocity(new Velocity(0, 4.6691e3));
        pluton.setFill(Color.GRAY);
        simulation.addParticle(pluton);

        return simulation;
    }

    public static Simulation getSimulation4() {
        var simulation = new Simulation();

        var blackHole = new Particle("Black Hole", 1.5e6 * 1.989e30, 0, 0);
        blackHole.setRadius(20);
        blackHole.setFill(Color.WHITE);
        simulation.addParticle(blackHole);

        var mercury = new Particle("Mercury", 3.285e23, -0.387 * Constants.AU, 0);
        mercury.setVelocity(new Velocity(0, -48e3));
        mercury.setFill(Color.ROSYBROWN);
        simulation.addParticle(mercury);

        var venus = new Particle("Venus", 4.867e24, -0.723 * Constants.AU, 0);
        venus.setVelocity(new Velocity(0, 35e3));
        venus.setFill(Color.WHEAT);
        simulation.addParticle(venus);

        var earth = new Particle("Earth", 5.9742e24, -1 * Constants.AU, 0);
        earth.setVelocity(new Velocity(0,  29.765e3));
        earth.setFill(Color.BLUE);
        simulation.addParticle(earth);

        var mars = new Particle("Mars", 6.39e23, -1.52 * Constants.AU, 0);
        mars.setVelocity(new Velocity(0, -24.13e3));
        mars.setFill(Color.RED);
        simulation.addParticle(mars);

        var jupiter = new Particle("Jupiter", 1.898e27, -5.2 * Constants.AU, 0);
        jupiter.setVelocity(new Velocity(0, 13.07e3));
        jupiter.setFill(Color.BROWN);
        simulation.addParticle(jupiter);

        var saturn = new Particle("Saturn", 5.683e26, -9.58 * Constants.AU, 0);
        saturn.setVelocity(new Velocity(0, -9.69e3));
        saturn.setFill(Color.WHITESMOKE);
        simulation.addParticle(saturn);

        var uran = new Particle("Uran", 8.6849e25, -19.1914 * Constants.AU, 0);
        uran.setVelocity(new Velocity(0, 6.81e3));
        uran.setFill(Color.AQUA);
        simulation.addParticle(uran);

        var neptun = new Particle("Neptun", 1.024e26, -30.1 * Constants.AU, 0);
        neptun.setVelocity(new Velocity(0, -5.4349e3));
        neptun.setFill(Color.DARKBLUE);
        simulation.addParticle(neptun);

        var pluton = new Particle("Pluton", 1.31e22, -39.482 * Constants.AU, 0);
        pluton.setVelocity(new Velocity(0, 4.6691e3));
        pluton.setFill(Color.GRAY);
        simulation.addParticle(pluton);

        return simulation;
    }

    public static Simulation getSimulation5() {
        Simulation simulation = new Simulation();

        Particle sun = new Particle("Sun", 1.989e30, 0, 0);
        sun.setRadius(20);
        sun.setFill(Color.YELLOW);
        simulation.addParticle(sun);

        Particle earth = new Particle("Earth", -5.9742e24, -1 * Constants.AU, 0);
        earth.setVelocity(new Velocity(0,  29.765e3));
        earth.setFill(Color.BLUE);
        simulation.addParticle(earth);

        return simulation;
    }

    public static Simulation getSimulation6() {
        Simulation simulation = new Simulation();

        Particle sun = new Particle("Sun", -1.989e30, 0, 0);
        sun.setRadius(20);
        sun.setFill(Color.YELLOW);
        simulation.addParticle(sun);

        Particle earth = new Particle("Earth", 5.9742e24, -1 * Constants.AU, 0);
        earth.setVelocity(new Velocity(0,  29.765e3));
        earth.setFill(Color.BLUE);
        simulation.addParticle(earth);

        return simulation;
    }

    public static Simulation getSimulation7() {
        Simulation simulation = new Simulation();

        Particle sun = new Particle("Sun", -1.989e30, 0, 0);
        sun.setRadius(20);
        sun.setFill(Color.YELLOW);
        simulation.addParticle(sun);

        Particle earth = new Particle("Earth", -5.9742e24, -1 * Constants.AU, 0);
        earth.setVelocity(new Velocity(0,  29.765e3));
        earth.setFill(Color.BLUE);
        simulation.addParticle(earth);

        return simulation;
    }
}
