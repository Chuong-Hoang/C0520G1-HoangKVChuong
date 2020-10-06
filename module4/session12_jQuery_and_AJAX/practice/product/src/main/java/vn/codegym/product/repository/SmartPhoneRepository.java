package vn.codegym.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.product.model.Smartphone;

public interface SmartPhoneRepository extends JpaRepository<Smartphone, Integer> {
}
