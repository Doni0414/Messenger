package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.*;

public class Universe extends Pane {
    private List<Particle> particles;
    private double dragStartX;
    private double dragStartY;
    private long timestamp;

    public Universe() {
        setStyle("-fx-background-color: black;");
        particles = new ArrayList<>();
        setOnMousePressed(e -> {
            dragStartX = e.getX();
            dragStartY = e.getY();
        });
        setOnMouseDragged(e -> {
            double dx = (e.getX() - dragStartX) / Constants.ZOOM / 50;
            double dy = (e.getY() - dragStartY) / Constants.ZOOM / 50;
            for (Node node: getChildren()) {
                if (node instanceof Particle p) {
                    p.setX(p.getX() + dx);
                    p.setY(p.getY() + dy);
                }
                else if (node instanceof Trace t){
                    t.setX(t.getX() + dx);
                    t.setY(t.getY() + dy);
                }
            }
        });
        setOnScroll(e -> {
            double zoomFactor = 1.05;
            if (e.getDeltaY() < 0) {
                zoomFactor = 2 - zoomFactor;
            }
            Constants.ZOOM *= zoomFactor;
        });
    }

    public void addParticle(Particle particle) {
        particles.add(particle);
        getChildren().add(particle);
    }

    public void start() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (int i = 0; i < particles.size(); i++) {
                    Particle curr = particles.get(i);
                    Velocity v = curr.getVelocity();
                    for (int j = 0; j < particles.size(); j++) {
                        if (i == j) {
                            continue;
                        }
                        Particle p = particles.get(j);
                        double dx = p.getX() - curr.getX();
                        double dy = p.getY() - curr.getY();

                        double angle = Math.atan2(dy, dx);
                        double r = Math.hypot(dx, dy);
                        double magnitude = Constants.G * p.getMass() / Math.pow(r, 2);

                        v.setxComp(v.getxComp() + Math.cos(angle) * magnitude * Constants.SPEED);
                        v.setyComp(v.getyComp() + Math.sin(angle) * magnitude * Constants.SPEED);
                    }
                }

                for (Particle p: particles) {
                    p.update();

                    Platform.runLater(() -> {
                        Trace trace = new Trace(p.getX(), p.getY());
                        trace.setFill(p.getFill());
                        trace.update();
                        getChildren().add(trace);
                    });
                }
                for (Node node: getChildren()) {
                    if (node instanceof Trace t) {
                        t.update();
                    }
                }
                updateTimestamp();
            }
        };
        timer.start();
    }

    private void updateTimestamp() {
        timestamp += (long) 1000 * Constants.SPEED;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(timestamp));
        Simulation simulation = (Simulation) getParent();

        Text time = simulation.getTime();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String hourFormat = hour < 10 ? "0%d" : "%d";
        String minuteFormat = minute < 10 ? "0%d" : "%d";
        String secondFormat = hour < 10 ? "0%d" : "%d";

        String format = "elapsed %d years, day %d, time: " + hourFormat + ":" + minuteFormat + ":" + secondFormat;

        time.setText(String.format(format,
                calendar.get(Calendar.YEAR) - 1970,
                calendar.get(Calendar.DAY_OF_YEAR), hour, minute, second));
    }
}
