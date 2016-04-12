package glavvlad.store.controller;

import glavvlad.store.model.Address;
import glavvlad.store.model.Customer;
import glavvlad.store.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String register(Model model) {
        Customer customer = new Customer();
        Address address = new Address();
        customer.setAddress(address);

        model.addAttribute("customer", customer);

        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registerForm";
        }

        if (!customerService.isEmailUnique(customer)) {
            model.addAttribute("emailError", "Email already exist.");
            return "registerForm";
        }

        if(!customerService.isUsernameUnique(customer)) {
            model.addAttribute("usernameError", "Username already exist.");
            return "registerForm";
        }

        customer.setEnabled(true);
        customerService.add(customer);

        return "registerFormSuccess";
    }
}
