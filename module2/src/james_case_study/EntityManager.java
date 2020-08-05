package james_case_study;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntityManager {
    private List<Entity> entityList;

    public EntityManager() {
        entityList = new ArrayList<>();
    }

    public EntityManager(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    /* _________ Manipulation data __________ */
    static Scanner sc = new Scanner(System.in);
    public void addNewEntity() {
        System.out.print("Input new keyword: ");
        String name = sc.nextLine();

        System.out.print("Input its pronounce: ");
        String pronoun = sc.nextLine();

        System.out.print("Input keyword's meaning: ");
        String meaning = sc.nextLine();

        System.out.print("Input word's class (noun/verb/adverb/adjective/...): ");
        String wordClass = sc.nextLine();

        int number = -1;
        do {
            System.out.print("How many synonym does this word have? ");
            number = Integer.parseInt(sc.nextLine());
        } while (number < 0);

        String[] synonym = new String[number];
        if (number > 0) {
            for (int i = 0; i < number; i++) {
                System.out.print("Input synonym " + i + ": ");
                synonym[i] = sc.nextLine();
            }
        }
        Entity entity = new Entity(name, pronoun, meaning, wordClass, synonym);
        entityList.add(entity);
        //show entity added:
        System.out.println(entity.toString());
    }

    public void removeEntity() {
        System.out.print("Input keyword to be dropped: ");
        String dropName = sc.nextLine();
        boolean isFound = false;
        Entity dropEntity = null;
        for (Entity entity : entityList) {
            if(dropName.equals(entity.getName())) {
                isFound = true;
                dropEntity = entity;
                System.out.println("Keyword '" + dropName + "' found in the dictionary.");
                break;
            }
        }

        if (isFound) {
            System.out.print("Drop the keyword '" + dropName + "' out of the dictionary? Yes(1) or No(0)? ");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                entityList.remove(dropEntity);
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
        for (Entity entity : entityList) {
            if (findingName.equals(entity.getName())) {
                isFound = true;
                System.out.println("Searching Result:");
                System.out.println("_________________");
                System.out.println(entity.toString());
                System.out.println("_________________________________________________________________________________");
                break;
            }
        }

        if (!isFound) {
            System.out.println("Keyword " + findingName + " not found in the dictionary. " + "\n" +
                    "Define new word? Yes(1) or No(0)? ");
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                addNewEntity();
            }
        }
    }
}
