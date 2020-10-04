package vn.codegym.picture.service;
import vn.codegym.picture.exception.BadWordsException;
import vn.codegym.picture.model.NasaPicture;

import java.util.List;

public interface NasaPictureService {
    List<NasaPicture> findAll();

    void save(NasaPicture t) throws BadWordsException;

    NasaPicture findById(int id);

    void remove(int id);
}
