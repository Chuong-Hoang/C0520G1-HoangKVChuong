package session16_io_binary_file.csv;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String brand;
    private double price;
    private String desc;

    public Product(String id, String name, String brand, String desc, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
    }

    public Product() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return  "id = " + id + "\t\t" +
                " name = " + name + "\t\t" +
                " brand = " + brand + "\t\t" +
                " desc = " + desc + "\t\t" +
                " price = " + price + "\t\t";
    }
}
