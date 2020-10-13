package vn.codegym.furama.service.sub_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.Position;

import java.util.List;

@Service
public interface PositionService {
    List<Position> findAll();

    Position findById(long id);

    void save(Position obj);

    void remove(long id);
}
