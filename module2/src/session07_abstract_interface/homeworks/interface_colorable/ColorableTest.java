package session07_abstract_interface.homeworks.interface_colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Square sq = new Square();
        sq.howToColor("Blue");

        Rectangle r = new Square(15);
        ((Square) r).howToColor("Brown");

        Shape sh = new Square("Yellow", true, 100);
        ((Square) sh).howToColor(sh.getColor());
        System.out.println();

        Shape[] shapeList = new Shape[3];
        shapeList[0] = new Square(10);
        shapeList[1] = new Circle(15);
        shapeList[2] = new Rectangle (15, 30);

        for(Shape s : shapeList) {
            System.out.println(s);
            if(s instanceof Square) {
                ((Square) s).howToColor("Blue");
            }
        }

    }
}
