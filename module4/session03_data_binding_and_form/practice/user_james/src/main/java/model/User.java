package model;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String gender;
    private boolean admin;
    private String type;
    private String country;
    private List<String> hobbies;

    public User() {
    }

    public User(String id, String name, String gender, boolean admin,
                String type, String country, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.admin = admin;
        this.type = type;
        this.country = country;
        this.hobbies = hobbies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
