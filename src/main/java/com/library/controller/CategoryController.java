package com.library.controller;

import com.library.entity.Category;
import com.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable ("id") Integer id) throws Exception {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    public Category putCategory(@PathVariable ("id") Integer id ,@RequestBody Category category) throws Exception {
        return categoryService.changeById(id,category);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Category postCategory(@RequestBody Category category) throws Exception {
        categoryService.createCategory(category);
        return category;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable ("id") Integer id)
    {
        categoryService.deleteById(id);
    }

    @GetMapping(value="/all")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }
}