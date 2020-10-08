package vn.codegym.blog_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog_manager.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
