package session06_inheritance.homeworks.circle_pack;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        System.out.println(cy);
        System.out.println();

        cy.setColor("RED");
        cy.setRadius(10);
        cy.setHeight(2);
        System.out.println(cy);
        cy.setColor("YELLOW");
        System.out.println(cy.toString());
        System.out.println();

        Circle c = new Cylinder();
        ((Cylinder)c).setHeight(10);
        System.out.println(c.toString());

    }
}
