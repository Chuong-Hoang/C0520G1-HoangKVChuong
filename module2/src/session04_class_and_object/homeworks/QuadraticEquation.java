package session04_class_and_object.homeworks;

public class QuadraticEquation {
    int a;
    int b;
    int c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    public double getDiscriminant(){
        return (this.b*this.b) - (4*this.a*this.c);
    }
    public double getRoot1(){
        return (-this.b + Math.sqrt(this.getDiscriminant()))/(2*this.a);
    }
    public double getRoot2(){
        return (-this.b - Math.sqrt(this.getDiscriminant()))/(2*this.a);
    }
}
