package vn.codegym.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.restful.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
