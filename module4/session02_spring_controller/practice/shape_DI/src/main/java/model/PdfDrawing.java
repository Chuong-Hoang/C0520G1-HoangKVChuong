package model;

import repository.Shape;

public class PdfDrawing implements Drawing {
    // attribute
    private Shape shape;

    // construct without parameter
    public PdfDrawing() {
    }

    // constructor with parameter (Shape shape)
    public PdfDrawing(Shape shape) {
        this.shape = shape;
    }

    // setter
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    // override (abstract) method of the interface Shape
    @Override
    public String showContent() {
        return "PDF drawing's content: " + this.shape.draw();
    }
}
