package vn.codegym.furama.service.main_service;

import org.springframework.stereotype.Service;
import vn.codegym.furama.model.main_model.AttachService;
import java.util.List;

@Service
public interface AttachServiceFuService {
    List<AttachService> findAll();

    AttachService findById(long id);

    void save(AttachService obj);

    void remove(long id);
}
