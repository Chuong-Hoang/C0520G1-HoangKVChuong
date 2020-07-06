package demo;

public class Demo {
    private String name;
    private int age;
    private String add;

    public Demo(){}

    public Demo(String name, int age, String add) {
        this.name = name;
        this.age = age;
        this.add = add;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
    public static void swap(Demo a, Demo b){
        String temp1 = a.name;
        a.name = b.name;
        b.name = temp1;

        int temp2 = a.age;
        a.age = b.age;
        b.age = temp2;

        String temp3 = a.add;
        a.add = b.add;
        b.add = temp3;
    }

    public static void main(String[] args) {
        Demo dm1 = new Demo("Chuong", 32, "To Hieu");
        Demo dm2 = new Demo("Thu Hong", 30, "Thanh Khe");
        swap(dm1, dm2);
        System.out.println(dm2.name + " " + dm2.age + " " + dm2.add);
    }
}
