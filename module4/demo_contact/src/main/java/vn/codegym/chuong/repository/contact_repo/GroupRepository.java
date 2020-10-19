package vn.codegym.chuong.repository.contact_repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.chuong.model.contact_model.ContactGroup;

public interface GroupRepository extends JpaRepository<ContactGroup, Long> {
}
