package session12_searching_algorithms.homeworks;
import java.util.*;

public class FindMaxAscendingString {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = myScanner.nextLine();
        LinkedList<Character> maxString = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> charList = new LinkedList<>();
            charList.add(str.charAt(i));
            for (int j = i +1; j < str.length(); j++) {
                if (str.charAt(j) > charList.getLast()) {
                    charList.add(str.charAt(j));
                }
            }

            if (charList.size() > maxString.size()) {
                maxString.clear();
                maxString.addAll(charList);
            }

            charList.clear();
        }

        //Display the maximum-length-ascending string
        for (Character ch : maxString) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
