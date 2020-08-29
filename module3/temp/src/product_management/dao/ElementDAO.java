package product_management.dao;

import product_management.model.Element;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ElementDAO {
    List<Element> findAll();

    void save(Element element);

    Element findById(int id);

    List<Element> findByName(String nameString);

    void update(int id, Element element);

    void remove(int id);

    int getNextId();

}
