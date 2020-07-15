package session5_access_modifers_and_static_keyword.more_homeworks;

public class StudentCodeGym {
    private int id;
    private String name;
    private String dateOfBirth;

    public StudentCodeGym(int id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
