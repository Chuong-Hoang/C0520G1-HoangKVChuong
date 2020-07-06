package session4_class_and_object.practice;

public class Rectangle_2 {
    private int width;
    private int height;
    public Rectangle_2(){
    }
    public Rectangle_2(int width, int height){
        this.width = width;
        this.height = height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public String display(){
        return "This rectangle: width = " + this.getWidth() + ", height = " + this.getHeight();
    }
    public int getArea(){
        return this.getWidth()*this.getHeight();
    }
    public int getPerimeter(){
        return (this.getWidth() + this.getHeight())*2;
    }

}
