package com.company;

import javafx.geometry.Orientation;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Simulation extends Pane {
    private Universe universe;
    private Text time;

    public Simulation() {
        this.universe = new Universe();
        universe.setMinWidth(Constants.W);
        universe.setMinHeight(Constants.H);
        getChildren().add(universe);

        Slider slider = new Slider();
        slider.setOrientation(Orientation.VERTICAL);
        slider.setMin(0.001);
        slider.setMax(10);
        slider.setMajorTickUnit(0.9999);
        slider.setMinorTickCount(3);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMinHeight(600);
        slider.setTranslateX(30);
        slider.setTranslateY(Constants.H / 2 - slider.getMinHeight() / 2);
        slider.setValue(1);
        slider.valueProperty().addListener(e -> {
            Constants.SPEED = Constants.TIMESTEP * slider.getValue();
        });
        getChildren().add(slider);

        time = new Text();
        time.setTranslateX(Constants.W / 2 - 10);
        time.setTranslateY(30);
        time.setFill(Color.WHITE);
        time.setFont(Font.font(15));
        getChildren().add(time);
    }

    public void addParticle(Particle particle) {
        universe.addParticle(particle);
    }

    public void start() {
        universe.start();
    }

    public Text getTime() {
        return time;
    }
}
