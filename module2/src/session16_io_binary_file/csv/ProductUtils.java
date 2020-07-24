package session16_io_binary_file.csv;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductUtils {
    public static final String FILE_PATH = "src/session16_io_binary_file/csv/AllProducts.csv";

    public static List<Product> readProductFile() {
        List<Product> productList = null;
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();

            fis.close();
            ois.close();
            //System.out.println("Read file completely...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            productList = new ArrayList<>();
        }
        return productList;
    }

    public static void writeProductFile(List<Product> productList) {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(productList);

            fos.flush();
            fos.close();
            oos.close();
            //System.out.println("Write file completely...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
