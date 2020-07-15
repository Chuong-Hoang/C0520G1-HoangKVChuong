package session10_stack_and_queue.homeworks.frequency_of_words_in_string_by_map;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class FrequencyOfCharacters {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Input a string: ");
        String input = myScanner.nextLine();
        getFrequencyOfCharacters(input);
    }

    public static void getFrequencyOfCharacters(String input) {
        Map<Character, Integer> myTreeMap = new TreeMap<>();
        input = input.toLowerCase();
        Character eachChar;
        int freq;
        for (int i = 0; i < input.length(); i++) {

            eachChar = input.charAt(i);
            if (eachChar != ' ') {
                if(myTreeMap.containsKey(eachChar)) {
                    freq = myTreeMap.get(eachChar);
                    freq++;
                } else {
                    freq = 1;
                }
                myTreeMap.put(eachChar, freq);
            }
        }
        //Set<Character> keys = myTreeMap.keySet();
        int i = 1;
        System.out.println("Key-Characters-Frequency");
        for (Character key : myTreeMap.keySet()) {
            System.out.println("Key " + i + ": " + key + " - " + myTreeMap.get(key));
            i++;
        }
    }
}
