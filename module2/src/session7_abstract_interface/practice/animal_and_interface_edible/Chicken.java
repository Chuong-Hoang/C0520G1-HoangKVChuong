package session7_abstract_interface.practice.animal_and_interface_edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken is speaking 'chip! chip! chip!'";
    }

    @Override
    public String howToEat() {
        return "Chicken could be fried.";
    }
}
