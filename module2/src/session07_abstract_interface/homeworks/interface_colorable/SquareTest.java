package session7_abstract_interface.homeworks.interface_colorable;

public class SquareTest {
    public static void main(String[] args) {
        Square s = new Square(10);
        s.howToColor("Red");

        Shape sh = new Square(22);
        ((Square) sh).howToColor("Green");

        Rectangle r = new Square();
        ((Square) r).howToColor("Bisque");
    }
}
