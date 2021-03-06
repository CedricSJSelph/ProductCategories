package com.dtcc.projects.productcategories.controllers;

import com.dtcc.projects.productcategories.models.Association;
import com.dtcc.projects.productcategories.models.Category;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.CategoryService;
import com.dtcc.projects.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController{

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public String getIndexPage(Model model){
        List<Product> prdocutList = productService.showAll();
        model.addAttribute("products", prdocutList);
        return "products/index";
    }

    @GetMapping("/products/newproduct")//.jsp file location/name
    public String newprod(Model model) {
        model.addAttribute("newproduct", new Product()); //Creating and inserting in JSp

        return "products/newproduct";//Returns .jsp page
    }

    @PostMapping(value = "/products/createproduct") //the action clause
    public String createProduct(@ModelAttribute("newproduct") Product item){//action attribute
        List<Product> temp = productService.showAll();
        item.setCreated_at(new Date());
        productService.saveProduct(item);

        for(Product p:temp) {
            if(p.getProductName().equals(item.getProductName())){
                productService.updateProduct(p.getProductId(), item.getProductName(),item.getDescription(), item.getPrice());
                p.setUpdated_at(new Date());
                productService.saveProduct(p);
                productService.deleteById(item.getProductId());
            }
        }

        return "redirect:/";//Go back to main page
    }

//    @RequestMapping(value="products/{id}",method=RequestMethod.GET)
//    public String showById(Model model,@PathVariable Integer id){
//        Product product = productService.findById(id);
//        List<Category> categoryList = categoryService.findByProductsNotContains(product);
//        Association association = new Association();
//
//        model.addAttribute("product",product);
//        model.addAttribute("association",association);
//        model.addAttribute("notInCategories",categoryList);
//        return "products/show";
//    }
}
