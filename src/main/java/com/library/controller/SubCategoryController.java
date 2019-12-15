package com.library.controller;

import com.library.entity.SubCategory;
import com.library.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/{id}")
    public SubCategory getSubCategory(@PathVariable ("id") Integer id) throws Exception {
        return subCategoryService.findById(id);
    }

    @PutMapping("/{id}")
    public SubCategory putCategory(@PathVariable ("id") Integer id ,@RequestBody SubCategory subCategory) throws Exception {
        return subCategoryService.changeById(id,subCategory);
    }

    @RequestMapping(method = RequestMethod.POST)
    public SubCategory postSubCategory(@RequestBody SubCategory subCategory) throws Exception {
        subCategoryService.createSubCategory(subCategory);
        return subCategory;
    }

    @DeleteMapping("/{id}")
    public void deleteSubCategory(@PathVariable ("id") Integer id)
    {
        subCategoryService.deleteById(id);
    }

    @GetMapping(value="/all")
    public List<SubCategory> getAllCategories() {
        return subCategoryService.getAll();
    }
}