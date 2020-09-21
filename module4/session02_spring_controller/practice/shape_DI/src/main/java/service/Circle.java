package service;

import repository.Shape;

public class Circle implements Shape {
    @Override
    public String draw() {
        return "drawing of 4 big circles.";
    }
}
