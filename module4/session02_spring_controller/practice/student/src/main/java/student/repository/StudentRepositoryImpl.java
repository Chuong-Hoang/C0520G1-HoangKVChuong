package student.repository;

import student.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {

    // Simulate an available database
    private static Map<String, Student> eMap;

    static{
        eMap = new HashMap<>();
        eMap.put("1", new Student ("1", "Chuong", "32"));
        eMap.put("2", new Student ("2", "Nhat", "32"));
        eMap.put("3", new Student ("3", "Quang", "32"));
        eMap.put("4", new Student ("4", "Toan", "32"));
        eMap.put("5", new Student ("5", "Hai", "32"));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(eMap.values());
    }

    @Override
    public void save(Student el) {
        eMap.put(el.getId(), el);
    }

    @Override
    public Student findById(String id) {
        return eMap.get(id);
    }

    @Override
    public void update(String id, Student el) {
        eMap.put(id, el);
    }

    @Override
    public void remove(String id) {
        eMap.remove(id);
    }
}
