package demo.file;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class WriterNhanVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<NhanVien> myList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Input id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Input name: ");
            String name = sc.nextLine();

            System.out.print("Input age: ");
            int age = sc.nextInt();

            System.out.print("Input salary: ");
            int salary = sc.nextInt();

            myList.add(new NhanVien(id, name, age, salary));
        }

        File f = new File("/WriteAndRead/nhanvien.txt");
        FileWriter fw = null;

        try {
            //B1: Create stream and link to source
            fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            //B2: Write data stream
            for (NhanVien nv : myList) {
                bw.write(nv.toString());
                bw.write("\n");
            }

            //B3: Close the stream
            bw.close();
            fw.close();
            System.out.println("Writing file successfully!");

        } catch (IOException e) {
            System.out.println("Error in writing: " + e);
        }
    }
}
