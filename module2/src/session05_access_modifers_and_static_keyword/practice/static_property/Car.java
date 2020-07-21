package session05_access_modifers_and_static_keyword.practice.static_property;

public class Car {
    private String name;
    private String id;
    private String color;
    private String model;
    public static int numberOfCars = 0;

    public Car(String name, String id, String color, String model) {
        numberOfCars++;
        this.name = name;
        this.id = id;
        this.color = color;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}