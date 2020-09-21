package service;

import repository.Shape;

public class Triangle implements Shape {
    @Override
    public String draw() {
        return "drawing of a triangle";
    }
}
