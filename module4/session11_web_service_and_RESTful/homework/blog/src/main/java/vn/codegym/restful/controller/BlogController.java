package vn.codegym.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.restful.model.Blog;
import vn.codegym.restful.service.BlogService;
import vn.codegym.restful.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<List<String>> getBlogTitleList(){
        List<Blog> blogList = blogService.findAll();
        List<String> titleList = new ArrayList<>();

        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for(Blog blog : blogList){
            titleList.add(blog.getTitle());
        }
        return new ResponseEntity<>(titleList, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<String> readBlogContent(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String content = blog.getContent();
        return new ResponseEntity<>(content, HttpStatus.OK);
    }
}
