package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.NasaPicture;
import vn.codegym.repository.NasaPictureRepository;

import java.util.List;
@Service
public class NasaPictureServiceImpl implements NasaPictureService {
    @Autowired
    NasaPictureRepository objectRepository;
    @Override
    public List<NasaPicture> findAll() {
        return objectRepository.findAll();
    }

    @Override
    public void save(NasaPicture t) {
        objectRepository.save(t);
    }

    @Override
    public NasaPicture findById(int id) {
        return objectRepository.findById(id);
    }

    @Override
    public void update(NasaPicture t) {
        objectRepository.update(t);
    }

    @Override
    public void remove(int id) {
        objectRepository.remove(id);
    }
}
