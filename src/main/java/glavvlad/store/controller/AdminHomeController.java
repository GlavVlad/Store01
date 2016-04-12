package glavvlad.store.controller;

import glavvlad.store.model.Customer;
import glavvlad.store.model.Product;
import glavvlad.store.service.CustomerService;
import glavvlad.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/product/list/all")
    public String productInventory(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customers")
    public String customers(Model model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "customers";
    }


}
