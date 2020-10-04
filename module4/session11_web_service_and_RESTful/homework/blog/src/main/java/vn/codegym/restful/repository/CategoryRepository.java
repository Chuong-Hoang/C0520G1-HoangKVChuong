package vn.codegym.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.restful.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
