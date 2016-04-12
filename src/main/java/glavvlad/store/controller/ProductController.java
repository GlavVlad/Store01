package glavvlad.store.controller;

import glavvlad.store.model.Product;
import glavvlad.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/list/all")
    public String getProducts(Model model) {
        List<Product> products = service.getAll();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) throws IOException {
        Product product = service.getById(id);
        model.addAttribute("product", product);

        return "viewProduct";
    }

    @RequestMapping("/list/{category}")
    public String getByCategory(@RequestParam("searchCondition") String searchCondition, Model model,
                                @PathVariable("category") String category) {
        List<Product> products = service.getByCategory(category);
        model.addAttribute("products", products);
        model.addAttribute("searchCondition", searchCondition);

        return "productList";
    }
}
