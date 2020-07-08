package session7_abstract_interface.homeworks.interface_colorable;

import session7_abstract_interface.homeworks.interface_resizeable.Resizeable;

public class Square extends Rectangle implements Resizeable, Colorable {
    private double side;

    public Square(){
        this.side = 1;
    }

    public Square(double side){
        super(side, side);
    }

    public Square(String color, boolean filled, double side){
        super(color, filled, side, side);
    }

    public double getSide(){
        return getWidth();
    }

    public void setSide(double side){
        this.setWidth(side);
        this.setHeight(side);
    }

    @Override
    public String toString() {
        return "A Square width " +
                "side=" + getSide() +
                ", which is a subclass of " + super.toString();
    }

    @Override
    public void howToColor(String color) {
        System.out.println("Color all four sides with " + color);
    }
}
