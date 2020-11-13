package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.CategoryService;
import com.dtcc.projects.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categories/category")
    public String getCategoryIndex(Model model){
        List<Category> categoryList = categoryService.showAll();
        model.addAttribute("categories", categoryList);
        return "categories/categoriesindex";
    }

    @GetMapping(value = "/categories/newcategory")
    public String newcat(Model model){
        model.addAttribute("newcategory", new Category());
        return "categories/newcategory";
    }

    @PostMapping(value = "/categories/createcategory")
    public String createCategory(@ModelAttribute("newcategory")Category cat){
        List<Category> temp = categoryService.showAll();
        cat.setCreated_at(new Date());
        boolean exists = false;
        for(Category c:temp){
            if(c.getValue().equals(cat.getValue())){
                exists = true;
            }
        }
        if(!exists){
            categoryService.saveCategory(cat);
        }
        return "redirect:/";
    }

}
