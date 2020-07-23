package session16_io_binary_file.homework.copy;

import session16_io_binary_file.demo.Employee;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String SOURCE_PATH = "src/session16_io_binary_file/homework/copy/Employee.txt";
        final String DEST_PATH = "src/session16_io_binary_file/homework/copy/EmployeeCopy.txt";

        File sourceFile = new File(SOURCE_PATH);
        File destFile = new File(DEST_PATH);

        copyFileUsingStream(sourceFile, destFile);

    }

    private static void copyFileUsingStream(File source, File dest) {
        FileInputStream fis;
        FileOutputStream fos;

        try {
            if (!source.exists()) {
                throw new FileNotFoundException("File does not exist");
            } else if (dest.exists()) {
                throw new IOException("File already exists.");
            } else {
                fis = new FileInputStream(source);
                fos = new FileOutputStream(dest);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            }

            fis.close();
            fos.flush();
            fos.close();

            System.out.println("Copy file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
