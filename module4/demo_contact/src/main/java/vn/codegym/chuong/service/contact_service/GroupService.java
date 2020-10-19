package vn.codegym.chuong.service.contact_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.contact_model.ContactGroup;

import java.util.List;

@Service
public interface GroupService {
    List<ContactGroup> findAll();

    ContactGroup findById(long id);

    void save(ContactGroup obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<ContactGroup> findAll(Pageable pageable);
}
