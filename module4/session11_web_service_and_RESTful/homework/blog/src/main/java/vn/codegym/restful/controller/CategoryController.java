package vn.codegym.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.codegym.restful.model.Blog;
import vn.codegym.restful.model.Category;
import vn.codegym.restful.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<String>> getCategoryNameList(){
        List<Category> categoryList = categoryService.findAll();
        List<String> categoryNames = new ArrayList<>();

        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for(Category category : categoryList){
            categoryNames.add(category.getCategoryName());
        }
        return new ResponseEntity<>(categoryNames, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<String>> getBlogListOfEachCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogList = (List<Blog>) category.getBlogList();
        List<String> blogNameList = new ArrayList<>();
        for(Blog blog : blogList){
            blogNameList.add(blog.getTitle());
        }
        return new ResponseEntity<>(blogNameList, HttpStatus.OK);
    }

}
