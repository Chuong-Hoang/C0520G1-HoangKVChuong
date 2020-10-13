package vn.codegym.furama.service.sub_service.sub_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furama.model.sub_model.Division;
import vn.codegym.furama.model.sub_model.Position;
import vn.codegym.furama.repository.sub_repo.DivisionRepository;
import vn.codegym.furama.repository.sub_repo.PositionRepository;
import vn.codegym.furama.service.sub_service.PositionService;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository xRepository;
    @Override
    public List<Position> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Position findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }
}
