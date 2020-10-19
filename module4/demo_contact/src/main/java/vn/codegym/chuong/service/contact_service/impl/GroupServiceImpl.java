package vn.codegym.chuong.service.contact_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.contact_model.ContactGroup;
import vn.codegym.chuong.repository.contact_repo.GroupRepository;
import vn.codegym.chuong.service.contact_service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository xRepository;
    @Override
    public List<ContactGroup> findAll() {
        return xRepository.findAll();
    }

    @Override
    public ContactGroup findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContactGroup obj) {
        xRepository.save(obj);
    }

    @Override
    public void remove(long id) {
        xRepository.deleteById(id);
    }

    @Override
    public long count() {
        return xRepository.count();
    }

    @Override
    public Page<ContactGroup> findAll(Pageable pageable) {
        return xRepository.findAll(pageable);
    }
}
