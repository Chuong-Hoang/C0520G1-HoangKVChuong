package vn.codegym.furama.service.main_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.AttachServiceFu;
import java.util.List;

@Service
public interface AttachServiceFuService {
    List<AttachServiceFu> findAll();

    AttachServiceFu findById(long id);

    void save(AttachServiceFu obj);

    void remove(long id);
}
