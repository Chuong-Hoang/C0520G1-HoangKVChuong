package vn.codegym.chuong.service.contact_service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.contact_model.Contact;

import java.util.List;

@Service
public interface ContactService {
    List<Contact> findAll();

    Contact findById(long id);

    void save(Contact obj);

    void remove(long id);

    long count();

    // findAll() paging and sorting
    Page<Contact> findAll(Pageable pageable);

    Page<Contact> findByNameAddressEmail(Pageable pageable, String text);

    // find status true
    Page<Contact> findAllByStatusTrue(Pageable pageable);

    // search on many fields
    Page<Contact> findByNameContaining(Pageable pageable, String str);
    Page<Contact> findByBirthdayContaining(Pageable pageable, String str);
    Page<Contact> findByAddressContaining(Pageable pageable, String str);
}
