package element_management.dao;

import element_management.dao.ElementDAO;
import element_management.model.Element;

import java.util.*;

public class ElementDAOImplement implements ElementDAO {
    private static Map<Integer, Element> elements;

    static {
        elements = new HashMap<>();

        elements.put(1, new Element(1, "Chuong", "20-04-1988", "abc@gmail.com", "012345", "Quang Tri 1", "C051", "CGDN"));
        elements.put(2, new Element(2, "Viet", "22-05-1984", "abcd@gmail.com", "014345", "Quang Tri 2", "C050", "CGDN"));
        elements.put(3, new Element(3, "Quan", "11-11-1995", "abce@gmail.com", "016545", "Quang Tri 3", "C052", "CGDN"));
        elements.put(4, new Element(4, "Minh", "10-10-1992", "abcss@gmail.com", "017645", "Quang Tri 4", "C055", "CGDN"));
        elements.put(5, new Element(5, "Hoang", "12-12-1992", "abcaf@gmail.com", "085345", "Quang Tri 5", "C054", "CGDN"));
    }

    @Override
    public List<Element> findAll() {
        return new ArrayList<>(elements.values());
    }

    @Override
    public void save(Element element) {
        elements.put(element.getId(), element);
    }

    @Override
    public Element findById(int id) {
        return elements.get(id);
    }

    @Override
    public List<Element> findByName(String nameString) {
        String str = nameString.toLowerCase();
        List<Element> elementList = new ArrayList<>(elements.values());
        List<Element> elementFound = new ArrayList<>();
        for(Element element: elementList){
            if (element.getName().toLowerCase().contains(str) ||
                element.getBirthday().contains(str) ||
                element.getEmail().contains(str) ||
                element.getPhone().contains(str)) {
                elementFound.add(element);
            }
        }

        return elementFound;
    }

    @Override
    public void update(int id, Element element) {
        elements.put(id, element);
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
