package session06_inheritance.homeworks.triangle_shape;

class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, double side1, double side2, double side3) {
        this(side1, side2, side3);
        super.setColor(color);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getHalfPerimeter(){
        return (getSide1()+getSide2()+getSide3())/2;
    }

    public double getPerimeter() {
        return 2*getHalfPerimeter();
    }

    public double getArea() {
        double p = getHalfPerimeter();
        double a = p*(p-getSide1())*(p-getSide2())*(p-getSide3());
        return Math.pow(a, 0.5);
    }

    @Override
    public String toString() {
        return "Triangle: \n" +
                "side1 = " + getSide1() + "\n" +
                "side2 = " + getSide2() + "\n" +
                "side3 = " + getSide3() + "\n" +
                "perimeter = " + getPerimeter() + "\n" +
                "area = " + getArea() + "\n" +
                "color = " + getColor();
    }
}
