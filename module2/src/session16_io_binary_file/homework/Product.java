package session16_io_binary_file.homework;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String brand;
    private double price;
    private String desc;

    public Product(String id, String name, String brand, double price, String desc) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.desc = desc;
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
        return  "id = " + id + "\t" +
                " name = " + name + "\t" +
                " brand = " + brand + "\t" +
                " price = " + price + "\t" +
                " desc = " + desc;
    }
}
