package session12_searching_algorithms.homeworks;
import java.util.*;

public class FindMaxContinuousString {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input a string: ");
        String input = myScanner.nextLine();
        findMaxContinuousCharacterString(input);
    }

    public static void findMaxContinuousCharacterString(String input) {
        ArrayList<Character> maxLength = new ArrayList<>();
        for (int i = 0; i <input.length(); i++) {
            ArrayList<Character> list = new ArrayList<>();
            list.add(input.charAt(i));
            for(int j = i+1; j < input.length(); j++) {
                if(input.charAt(j) > list.get(list.size()-1)) {
                    list.add(input.charAt(j));
                } else {
                    break;
                }
            }

            // replace elements in 'maxLength' by elements in 'list'
            if(list.size() > maxLength.size()) {
                maxLength.clear();
                maxLength.addAll(list);
            }
            list.clear();
        }

        // Display maximum-length continuous-character string
        for (Character ch : maxLength) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
