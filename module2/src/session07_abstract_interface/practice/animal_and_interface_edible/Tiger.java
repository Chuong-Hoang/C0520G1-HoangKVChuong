package session7_abstract_interface.practice.animal_and_interface_edible;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger is roaring so loudly";
    }

    @Override
    public String howToEat() {
        return "Tiger could be toasted.";
    }
}
