package com.library.service;


import com.library.entity.Category;
import com.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) throws Exception {
        return categoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        categoryRepository.deleteById(id);
        return "Category number " + id + " has been deleted!";
    }

    public Category changeById(Integer id,Category category) throws Exception {
        return categoryRepository.findById(id)
                .map(newcategory-> {
                    newcategory.setId(category.getId());
                    newcategory.setDescription(category.getDescription());
                    newcategory.setName(category.getName());
                    return categoryRepository.save(category);
                }).orElseThrow( Exception::new);
    }

    public Category createCategory(Category category)  {
        return categoryRepository.save(category);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

}