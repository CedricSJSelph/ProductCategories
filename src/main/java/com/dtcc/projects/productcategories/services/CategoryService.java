package com.dtcc.projects.productcategories.services;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> showAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Integer ID){
        return categoryRepository.findById(ID).orElse(null);
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateProduct(Integer id, String Name){
        Category category= findById(id);
        if (Name!= null) {
            category.setValue(Name);
        } else {
            category.setValue(category.getValue());
        }
        category.setUpdated_at(new Date());
        return categoryRepository.save(category);
    }

    public void deleteById(Integer ID){
        categoryRepository.deleteById(ID);
    }

//    public List<Category> findByProductsNotContains(Product product){
//        return categoryRepository.findByProductsNotContains(product);
//    }
}
