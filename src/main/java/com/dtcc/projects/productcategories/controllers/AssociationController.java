package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class AssociationController {
    @Autowired
    private CategoryRepository categoryRepository;

//    @RequestMapping(value="/categories/createcategory", method= RequestMethod.POST)
//    public void addNewCategory(@ModelAttribute("newcategory") Category category) {
//        Category test = new Category(category.getValue());
//        categoryRepository.save(test);
//    }

}
