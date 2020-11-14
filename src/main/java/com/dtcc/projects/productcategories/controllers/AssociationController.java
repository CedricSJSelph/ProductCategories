import com.dtcc.projects.productcategories.models.Association;
import com.dtcc.projects.productcategories.models.Product;
import com.dtcc.projects.productcategories.services.AssociationService;
import com.dtcc.projects.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AssociationController {


    @Autowired
    private AssociationService associationService;
    @Autowired
    private ProductService productService;


    @RequestMapping(value="/associations/products",method=RequestMethod.POST)
    public String setCategoriesProducts(Model model, @ModelAttribute("association") Association association){
        List<Product>productList = productService.showAll();
        model.addAttribute("products",productList);

        //save data into categories_products table.
        associationService.saveAssociation(association);
        return "/products/index";
    }

//    @RequestMapping(value="/associations/categories",method=RequestMethod.POST)
//    public String getCategory(Model model, @ModelAttribute("association1") Association associationObj){
//        List<Product> productList =  productService.showAll();
//        model.addAttribute("products",productList);
//        associationService.saveAssociation(associationObj);
//        return "/products/index";
//    }
}
