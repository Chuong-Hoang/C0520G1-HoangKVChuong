package vn.codegym.picture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.picture.exception.BadWordsException;
import vn.codegym.picture.model.NasaPicture;
import vn.codegym.picture.repository.NasaPictureRepository;
import java.util.List;

@Service
public class NasaPictureServiceImpl implements NasaPictureService {
    @Autowired
    NasaPictureRepository nasaPictureRepository;

    @Autowired
    BadWords badWords;

    @Override
    public List<NasaPicture> findAll() {
        return nasaPictureRepository.findAll();
    }

    @Override
    public void save(NasaPicture picture) throws BadWordsException {
        List<String> badWordList = badWords.getBadWordList();
        for(String badWord : badWordList){
            if (picture.getFeedback().toLowerCase().contains(badWord)){
                throw new BadWordsException();
            }
        }
        nasaPictureRepository.save(picture);
    }

    @Override
    public NasaPicture findById(int id) {
        return nasaPictureRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        nasaPictureRepository.deleteById(id);
    }
}
