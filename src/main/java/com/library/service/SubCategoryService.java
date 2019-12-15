package com.library.service;


import com.library.entity.SubCategory;
import com.library.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory findById(Integer id) throws Exception {
        return subCategoryRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        subCategoryRepository.deleteById(id);
        return "SubCategory number " + id + " has been deleted!";
    }

    public SubCategory changeById(Integer id,SubCategory subCategory) throws Exception {
        return subCategoryRepository.findById(id)
                .map(newsubcategory-> {
                    newsubcategory.setId(subCategory.getId());
                    newsubcategory.setCategoryId(subCategory.getCategoryId());
                    newsubcategory.setDescription(subCategory.getDescription());
                    newsubcategory.setName(subCategory.getDescription());
                    return subCategoryRepository.save(newsubcategory);
                }).orElseThrow( Exception::new);
    }

    public SubCategory createSubCategory(SubCategory subCategory)  {
        return subCategoryRepository.save(subCategory);
    }

    public List<SubCategory> getAll(){
        return subCategoryRepository.findAll();
    }

}