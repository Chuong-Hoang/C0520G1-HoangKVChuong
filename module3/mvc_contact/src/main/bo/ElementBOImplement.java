package main.bo;

import main.dao.ElementDAO;
import main.dao.ElementDAOImplement;
import main.model.Element;

import java.util.List;

public class ElementBOImplement implements ElementBO {
    ElementDAO elementDAO = new ElementDAOImplement();
    @Override
    public List<Element> findAll() {
        return elementDAO.findAll();
    }

    @Override
    public void save(Element element) {
        elementDAO.save(element);

    }

    @Override
    public Element findById(int id) {
        return elementDAO.findById(id);
    }

    @Override
    public List<Element> findByName(String nameString) {
        return elementDAO.findByName(nameString);
    }

    @Override
    public void update(int id, Element element) {
        elementDAO.update(id, element);
    }

    @Override
    public void remove(int id) {
        elementDAO.remove(id);
    }

    @Override
    public int getNextId() {
        return elementDAO.getNextId();
    }
}