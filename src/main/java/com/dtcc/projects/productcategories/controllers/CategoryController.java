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
        categoryService.saveCategory(cat);
        return "redirect:/";
    }

//@GetMapping("/products/newproduct")//.jsp file location/name
//public String newprod(Model model) {
//    model.addAttribute("newproduct", new Product()); //Creating and inserting in JSp
//    return "products/newproduct";//Returns .jsp page
//}
}
