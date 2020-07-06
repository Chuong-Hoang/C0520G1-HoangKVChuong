package session5_access_modifers_and_static_keyword.homeworks;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    public Circle (){};
    public Circle (double radius){
        this.radius = radius;
    }
    public double getRadius(){
        System.out.println("Public access modifier");
        return this.radius;
    }
   public double getArea(){
       System.out.println("Public access modifier");
        return Math.PI*this.radius*this.radius;
    }

}
