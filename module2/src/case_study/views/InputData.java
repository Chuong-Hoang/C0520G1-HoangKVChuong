package case_study.views;

public class InputData {
    private static final String SPACE_SEPARATOR = " ";

    public static void main(String[] args) {
        //Test
        String name = "Hoang";
        System.out.println("Last Name: " + getLastNameIndex(name));
        String birthday = "20/08/1976";
        System.out.println("Birth Year: " + getBirthYear(birthday));
    }

    public static String getLastNameIndex(String name) {
        int lastNameIndex = name.lastIndexOf(SPACE_SEPARATOR) + 1;
        String lastName = name.substring(lastNameIndex);
        return lastName;
    }

    public static int getBirthYear(String birthday){
        int birthYear = Integer.parseInt(birthday.substring(6));
        return birthYear;
    }
}
