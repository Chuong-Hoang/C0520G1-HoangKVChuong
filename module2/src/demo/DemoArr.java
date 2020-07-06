package demo;

public class DemoArr {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {10,20,30,40,50};
//        int[] temp = a;
//        a = b;
//        b = temp;
        swap(a, b);
        System.out.println(a[4]);
        System.out.println(b[4]);
    }

    public static void swap(int[] arr1, int[] arr2){
        System.out.print("Array 1 before swap: ");
        for(int x : arr1){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("Array 2 before swap: ");
        for(int y : arr2){
            System.out.print(y + " ");
        }
        System.out.println();
        int[] temp = arr1;
        arr1 = arr2;
        arr2 = temp;

        System.out.print("Array 1 after swap: ");
        for(int x1 : arr1){
            System.out.print(x1 + " ");
        }
        System.out.println();
        System.out.print("Array 2 after swap: ");
        for(int y1 : arr2) {
            System.out.print(y1 + " ");
        }
        System.out.println();
    }

}
