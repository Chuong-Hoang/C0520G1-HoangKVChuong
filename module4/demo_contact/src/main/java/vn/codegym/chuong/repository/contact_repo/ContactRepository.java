package vn.codegym.chuong.repository.contact_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.contact_model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Page<Contact> findAllByStatusTrue(Pageable pageable);
    Page<Contact> findContactByNameContainingOrAddressContainingOrEmailContainingOrderByName(Pageable pageable, String name, String address, String email);

    // search on many fields
    Page<Contact> findByNameContaining(Pageable pageable, String str);
    Page<Contact> findByBirthdayContaining(Pageable pageable, String str);
    Page<Contact> findByAddressContaining(Pageable pageable, String str);
}
