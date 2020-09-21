package model;

import repository.Shape;

public class AutocadDrawing implements Drawing {
    // attribute
    private Shape shape;

    // constructor without parameter
    public AutocadDrawing() {
    }

    // constructor with parameter (Shape shape)
    public AutocadDrawing(Shape shape) {
        this.shape = shape;
    }

    // setter
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    // override (abstract) method of the interface Shape
    @Override
    public String showContent() {
        return "Autocad Drawing's content: " + this.shape.draw();
    }
}
