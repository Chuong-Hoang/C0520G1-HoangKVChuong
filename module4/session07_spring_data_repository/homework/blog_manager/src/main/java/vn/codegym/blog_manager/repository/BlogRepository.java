package vn.codegym.blog_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog_manager.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
