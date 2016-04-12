package glavvlad.store.controller;

import glavvlad.store.model.Product;
import glavvlad.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

    private final static String imagesDir = "\\WEB-INF\\resources\\images\\";
    private Path path;

    @Autowired
    private ProductService service;

    @RequestMapping("/product/add")
    public String add(Model model) {
        Product product = new Product();
        product.setCategory("Tea");
        product.setCondition("New");
        product.setStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                          HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        service.addOrEdit(product);

        saveImage(product, request);

        return "redirect:/admin/product/list/all";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Product product = service.getById(id);

        model.addAttribute("product", product);

        return "editProduct";
    }

    @RequestMapping(value = "/product/edit", method = RequestMethod.POST)
    public String editPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                           HttpServletRequest request) {
        if (result.hasErrors()) {
            return "editProduct";
        }

        service.addOrEdit(product);

        saveImage(product, request);

        return "redirect:/admin/product/list/all";
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) {
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + imagesDir + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception ignored) {

            }
        }

        Product product = service.getById(id);
        service.delete(product);

        return "redirect:/admin/product/list/all";
    }

    private void saveImage(@Valid @ModelAttribute("product") Product product, HttpServletRequest request) {
        MultipartFile image = product.getImage();
        String rootDir = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDir + imagesDir + product.getId() + ".png");

        if (image != null && !image.isEmpty()) {
            try {
                image.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Image saving failed");
            }
        }
    }
}
