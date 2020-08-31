package main.dao;

import main.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImplement implements UserDAO {
    private static Map<Integer, User> elements;

    static {
        elements = new HashMap<>();

        //Set properties
        String email = "chuong123@gmail.com";
        String country = "Vietnam";
        elements.put(1, new User(1, "Chuong", email, country));
        elements.put(2, new User(2, "Nguyen",  email, country));
        elements.put(3, new User(3, "Tuan", email, country));
        elements.put(4, new User(4, "Thao",  email, country));
        elements.put(5, new User(5, "Nhung", email, country));
        elements.put(6, new User(6, "Hong", email, country));
        elements.put(7, new User(7, "Huyen", email, country));
        elements.put(8, new User(8, "Dung", email, country));
        elements.put(9, new User(9, "Son", email, country));
        elements.put(10, new User(10, "Nguyet", email, country));

    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(elements.values());
    }

    @Override
    public void save(User user) {
        elements.put(user.getId(), user);
    }

    @Override
    public User findById(int id) {
        return elements.get(id);
    }

    @Override
    public List<User> findByName(String nameString) {
        String str = nameString.toLowerCase();
        List<User> userList = new ArrayList<>(elements.values());
        List<User> userFound = new ArrayList<>();
        for (User user : userList) {
            if (user.getName().toLowerCase().contains(str) ||
                    user.getEmail().contains(str) ||
                    user.getCountry().contains(str)) {
                userFound.add(user);
            }
        }

        return userFound;
    }

    @Override
    public void update(int id, User user) {
        elements.put(id, user);
    }

    @Override
    public void remove(int id) {
        elements.remove(id);
    }

    @Override
    public int getNextId() {
        return elements.size() + 1;
    }
}
