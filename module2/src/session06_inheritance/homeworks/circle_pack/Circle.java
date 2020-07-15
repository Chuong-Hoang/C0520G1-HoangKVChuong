package session6_inheritance.homeworks.circle_pack;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        radius = 1;
        color = "Blue";
    }

    public Circle(double radius){
        this();
        this.radius = radius;
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public double getArea(){
        return this.radius*this.radius*Math.PI;
    }

    public double getPerimeter(){
        return this.radius*2*Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with " +
                "radius = " + getRadius()
                + " and color is " + getColor();
    }

    @Override
    public boolean equals(Object obj) {
        Circle c = (Circle) obj;
        if(this.radius == c.getRadius() && this.color.equals(c.getColor())) {
            return true;
        } else return false;
    }
}
