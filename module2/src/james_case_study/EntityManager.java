package james_case_study;

import java.util.*;

public class EntityManager {
    private Map<String, Entity> entityTreeMap;

    public EntityManager() {
        entityTreeMap = new TreeMap<>();
    }

    public EntityManager(Map<String, Entity> entityTreeMap) {
        this.entityTreeMap = entityTreeMap;
    }

    public Map<String, Entity> getEntityTreeMap() {
        return entityTreeMap;
    }

    public void setEntityTreeMap(Map<String, Entity> entityTreeMap) {
        this.entityTreeMap = entityTreeMap;
    }

    /* ____________________________________________ Manipulation data _____________________________________________ */

    static Scanner sc = new Scanner(System.in);

    public void addNewEntity() {
        System.out.print("Input new keyword: ");
        String name = sc.nextLine();
        String pronoun;
        String meaning;
        String wordClass;


        System.out.print("Input its pronoun: ");
        pronoun = sc.nextLine();

        System.out.print("Input keyword's meaning: ");
        meaning = sc.nextLine();

        System.out.print("Input word's class (noun/verb/adverb/adjective/prep./...): ");
        wordClass = sc.nextLine();

        int number = -1;
        do {
            System.out.print("How many synonym does this word have? ");
            number = Integer.parseInt(sc.nextLine());
        } while (number < 0);

        String[] synonym = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Input synonym " + i + ": ");
            synonym[i] = sc.nextLine();
        }

        Entity entity = new Entity(name, pronoun, meaning, wordClass, synonym);
        entityTreeMap.put(name, entity);

        //show entity added:
        System.out.println("...........New word defined...........");
        System.out.println(entity.toString());
    }

    public void removeEntity() {
        System.out.print("Input keyword to be dropped: ");
        String dropName = sc.nextLine();
        boolean isFound = false;
        Entity dropEntity = null;
        for (String name : entityTreeMap.keySet()) {
            if (dropName.equals(name)) {
                isFound = true;
                dropEntity = entityTreeMap.get(name);
                System.out.println("Keyword '" + dropName + "' found in the dictionary.");
                System.out.println(dropEntity.toString());
                break;
            }
        }

        if (isFound) {
            System.out.print("Drop the keyword '" + dropName + "' out of the dictionary? Yes(1) or No(0)? ");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                entityTreeMap.remove(dropName);
            } else {
                System.out.println("No keyword dropped.");
            }
        } else {
            System.out.println("Keyword " + dropName + " not found in the dictionary.");
        }
    }

    public void findEntity() {
        System.out.print("Input a keyword: ");
        String findingName = sc.nextLine();
        boolean isFound = false;
        for (String name : entityTreeMap.keySet()) {
            if (findingName.equals(name)) {
                isFound = true;
                System.out.println("_________________");
                System.out.println("Searching Result:");
                System.out.println(entityTreeMap.get(findingName).toString());
                System.out.println(". . . . . . . . . . . . . . . . . . . .");
                break;
            }
        }

        if (!isFound) {
            System.out.print("Keyword " + findingName + " not found in the dictionary. " + "\n" +
                    "Define new word? Yes(1) or No(0)? ");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                addNewEntity();
            }
        }
    }
}