package session7_abstract_interface.homeworks.interface_resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double height;

    public Rectangle(){
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public Rectangle (String color, boolean filled, double width, double height){
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return height*width;
    }

    public double getPerimeter(){
        return 2*(width + height);
    }

    @Override
    public String toString() {
        return "A Rectangle with " +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        width *= (1 + (percent/100));
        height *= (1 + (percent/100));
    }
}
