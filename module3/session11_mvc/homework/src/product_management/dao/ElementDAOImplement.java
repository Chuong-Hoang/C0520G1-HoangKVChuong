package product_management.dao;

import product_management.model.Element;

import java.util.*;

public class ElementDAOImplement implements ElementDAO {
    private static Map<Integer, Element> elements;

    static {
        elements = new HashMap<>();

        elements.put(1, new Element(1, "Pa_1", "1000", "...", "A"));
        elements.put(2, new Element(2, "Pan_2", "1200", "...", "B"));
        elements.put(3, new Element(3, "Pbn_3", "1400", "...", "C"));
        elements.put(4, new Element(4, "Prn_4", "1600", "...", "D"));
        elements.put(5, new Element(5, "Pacb_5", "1800", "...", "E"));
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
        List<Element> elementList = new ArrayList<>(elements.values());
        List<Element> elementFound = new ArrayList<>();
        for(Element element: elementList){
            if (element.getName().toLowerCase().contains(nameString.toLowerCase())) {
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
