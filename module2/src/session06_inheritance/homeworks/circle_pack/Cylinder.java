package session6_inheritance.homeworks.circle_pack;

import session6_inheritance.homeworks.circle_pack.Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){
        height = 1;
    }

    public Cylinder(double height){
        this.height = height;
    }

    public Cylinder(double radius, String color, double height){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 2*super.getArea() + super.getPerimeter()*this.getHeight();
    }


    public double getVolume(){
        return super.getArea()*this.getHeight();
    }

    @Override
    public String toString() {
        return "A Cylinder with " +
                "height = " + getHeight() +
                " and area = " + getArea() +
                " and volume = " + getVolume() +
                ", which is a subclass of " + super.toString();
    }
}
