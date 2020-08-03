package session_consolidation.io_byte;

import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String name;
    private String address;
    private int totalFee;

    public Student() {
    }

    public Student(String id, String name, String address, int totalFee) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.totalFee = totalFee;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    @Override
    public String toString() {
        return "id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", address = '" + address + '\'' +
                ", total_fee = " + totalFee;
    }
}
