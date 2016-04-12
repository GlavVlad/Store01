package glavvlad.store.controller;


import glavvlad.store.model.Customer;
import glavvlad.store.service.CustomerService;
import glavvlad.store.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService service;

    @RequestMapping
    public String get(@AuthenticationPrincipal User activeUser) {
        Customer customer = service.getByUsername(activeUser.getUsername());
        int id = customer.getCart().getId();

        return "redirect:/customer/cart/" + id;
    }

    @RequestMapping("/{id}")
    public String getRedirect(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);

        return "cart";
    }
}
