package main.dao;

import main.model.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementDAOImplement implements ElementDAO {
    private static Map<Integer, Element> elements;

    static {
        elements = new HashMap<>();

        elements.put(1, new Element(1, "Chuong", "20041988", "Friend"));
        elements.put(2, new Element(2, "Nguyen", "20041988", "Family"));
        elements.put(3, new Element(3, "Tuan", "20041988", "Friend"));
        elements.put(4, new Element(4, "Thao", "20041988", "Family"));
        elements.put(5, new Element(5, "Nhung", "20041988", "Family"));
        elements.put(6, new Element(6, "Hong", "20041988", "Friend"));
        elements.put(7, new Element(7, "Huyen", "20041988", "Company"));
        elements.put(8, new Element(8, "Dung", "20041988", "Company"));
        elements.put(9, new Element(9, "Son", "20041988", "Friend"));
        elements.put(10, new Element(10, "Nguyet", "20041988", "Company"));

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
        for (Element element : elementList) {
            if (element.getProp_A().toLowerCase().contains(str) ||
                    element.getProp_B().contains(str) ||
                    element.getProp_C().contains(str)) {
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
