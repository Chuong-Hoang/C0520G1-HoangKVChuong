package array_and_methods_in_java.thuc_hanh;
import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int size = 0;
        while(size <= 0 || size > 20){
            System.out.print("Enter the quantity of millionaire: ");
            size = myScanner.nextInt();
        }
        double billionaireList[] = new double[size];
        for(int i = 0; i < size; i++){
            System.out.print("Input the amount of billionaire number " + (i + 1) + ": ");
            billionaireList[i] = myScanner.nextDouble();
        }
        for(double acc : billionaireList){
            System.out.print(acc + " ");
        }
        System.out.println("");
        double max = billionaireList[0];
        int index = -1;
        for(int i = 0; i < size; i++){
            if(max < billionaireList[i]) {
                max = billionaireList[i];
                index = i;
            }
        }
        System.out.println("The richest billionaire has B$." + max + " at index " + index);
    }
}
