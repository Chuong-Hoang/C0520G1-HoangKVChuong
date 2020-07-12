package session4_class_and_object.homeworks;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed;
    private boolean on = false;
    private double radius = 5.0;
    private String color = "blue";
    public Fan(){
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String toString(){
        if(this.isOn()){
            return "Fan is on, speed = " + this.getSpeed() +
                    ". Its color is " + this.getColor() +
                    " and radius = " + this.getRadius() + ".";
        } else {
            return "Fan is off. Its color is " + this.getColor() +
                    " and radius = " + this.getRadius() + ".";
        }
    }
}