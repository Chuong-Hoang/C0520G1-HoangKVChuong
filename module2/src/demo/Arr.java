package demo;
import java.util.Scanner;

public class Arr {
    private String name;
    private int age;

    public Arr() {
    }

    public Arr(String name, int age) {
        this.name = name;
        this.age = age;
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

    // MAIN() METHOD
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Arr objArr;
        Arr[] objList = new Arr[5];
        for(int i = 0; i < 5; i++){
            System.out.println("Create object " + (i+1));
            System.out.print("Input name: ");
            String name = myScanner.nextLine();

            System.out.print("Input age: ");
            int age = myScanner.nextInt();
            myScanner.nextLine();

            objArr = new Arr(name, age);
            objList[i]= objArr;
        }
        System.out.println("----Before Sort Age-----");
        for(Arr x : objList){
            System.out.println(x.getName() + ": " + x.getAge());
        }

        sortAge(objList);

        System.out.println("----After Sort Age-----");
        for(Arr x : objList){
            System.out.println(x.getName() + ": " + x.getAge());
        }
    }

    //sort attribute age in array
    public static void sortAge(Arr[] a) {
        Arr temp;
        boolean flag;
        for (int n = 0; n < a.length; n++){
            flag = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getAge() > a[i + 1].getAge()) {
                    flag = false;
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            if(flag) break;
        }
    }
}
