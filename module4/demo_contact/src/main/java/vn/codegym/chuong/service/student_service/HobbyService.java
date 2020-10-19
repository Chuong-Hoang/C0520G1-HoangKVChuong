package vn.codegym.chuong.service.student_service;

import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.student_model.Hobby;

import java.util.List;

@Service
public interface HobbyService {
    List<Hobby> findAll();

    Hobby findById(long id);

    void save(Hobby obj);

    void remove(long id);
}
