package repository;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private static Map<String, User> eMap;
    static {
        eMap = new HashMap<>();
        List<String> hobby1 = new ArrayList<>();
        hobby1.add("travel");
        hobby1.add("music");
        List<String> hobby2 = hobby1;
        hobby2.add("sport");

        eMap.put("1", new User("1", "Chuong", "male", true, "internal", "Vietnam", hobby1));
        eMap.put("2", new User("2", "Toan", "other", false, "external", "Korea", hobby2));
        eMap.put("3", new User("3", "Quang", "female", true, "internal", "Japan", hobby1));
        eMap.put("4", new User("4", "Nhat", "other", false, "external", "USA", hobby2));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(eMap.values());
    }

    @Override
    public void save(User el) {
        eMap.put(el.getId(), el);
    }

    @Override
    public User findById(String id) {
        return eMap.get(id);
    }

    @Override
    public void update(String id, User el) {
        eMap.put(id, el);
    }

    @Override
    public void remove(String id) {
        eMap.remove(id);
    }
}
