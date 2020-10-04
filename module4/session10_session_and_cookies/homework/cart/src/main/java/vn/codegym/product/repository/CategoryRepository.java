package vn.codegym.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.product.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
