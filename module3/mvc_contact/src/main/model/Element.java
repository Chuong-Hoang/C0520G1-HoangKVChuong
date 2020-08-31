package main.model;

public class Element {
    private int id;
    private String prop_A; //name
    private String prop_B; //number
    private String prop_C; //group

    public Element() {
    }

    public Element(int id, String prop_A, String prop_B, String prop_C) {
        this.id = id;
        this.prop_A = prop_A;
        this.prop_B = prop_B;
        this.prop_C = prop_C;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProp_A() {
        return prop_A;
    }

    public void setProp_A(String prop_A) {
        this.prop_A = prop_A;
    }

    public String getProp_B() {
        return prop_B;
    }

    public void setProp_B(String prop_B) {
        this.prop_B = prop_B;
    }

    public String getProp_C() {
        return prop_C;
    }

    public void setProp_C(String prop_C) {
        this.prop_C = prop_C;
    }
}
