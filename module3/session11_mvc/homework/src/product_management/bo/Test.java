package product_management.bo;

import product_management.model.Element;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ElementBO elementBO = new ElementBOImplement();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a name to find: ");
        String name = sc.nextLine();
        List<Element> elementList = elementBO.findByName(name);

        for(Element element : elementList) {
            System.out.println(element.getName() + " --- " + element.getPrice());
        }

    }
}
