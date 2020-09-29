package vn.codegym.blog_manager.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;

    @OneToMany(targetEntity = Blog.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id")
    private Collection<Blog> blogList;

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(Collection<Blog> blogList) {
        this.blogList = blogList;
    }
}
