package service;

import repository.Shape;

public class Rectangle implements Shape {
    @Override
    public String draw() {
        return "drawing of so many rectangles.";
    }
}
