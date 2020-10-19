package vn.codegym.chuong.service.contact_service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.chuong.model.contact_model.Contact;
import vn.codegym.chuong.repository.contact_repo.ContactRepository;
import vn.codegym.chuong.service.contact_service.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository xRepository;

    @Override
    public List<Contact> findAll() {
        return xRepository.findAll();
    }

    @Override
    public Contact findById(long id) {
        return xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contact obj) {
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
    public Page<Contact> findAll(Pageable pageable) {
        return xRepository.findAll(pageable);
    }

    // find by 3 field
    @Override
    public Page<Contact> findByNameAddressEmail(Pageable pageable, String text) {
        return xRepository.findContactByNameContainingOrAddressContainingOrEmailContainingOrderByName(pageable, text, text, text);
    }

    // find status true
    @Override
    public Page<Contact> findAllByStatusTrue(Pageable pageable) {
        return xRepository.findAllByStatusTrue(pageable);
    }

    // find on each field
    @Override
    public Page<Contact> findByNameContaining(Pageable pageable, String str) {
        return xRepository.findByNameContaining(pageable, str);
    }

    @Override
    public Page<Contact> findByBirthdayContaining(Pageable pageable, String str) {
        return xRepository.findByBirthdayContaining(pageable, str);
    }

    @Override
    public Page<Contact> findByAddressContaining(Pageable pageable, String str) {
        return xRepository.findByAddressContaining(pageable, str);
    }

}
