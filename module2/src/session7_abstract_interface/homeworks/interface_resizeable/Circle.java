package session7_abstract_interface.homeworks.interface_resizeable;

//Subclass Circle extends Superclass Shape
public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle(){
        this.radius = 1.0;
    }

    public Circle (String color, boolean filled, double radius){
        super(color, filled);
        this.radius = radius;
    }

    public Circle (double radius){
        this.radius = radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }

    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public String toString(){
        return "A Circle width radius = "
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.radius *= (1+ (percent/100));
    }
}
