package session7_abstract_interface.homeworks.interface_colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Square sq = new Square();
        sq.howToColor("Blue");

        Rectangle r = new Square(15);
        ((Square) r).howToColor("Brown");

        Shape sh = new Square("Yellow", true, 100);
        ((Square) sh).howToColor(sh.getColor());
    }
}
