package glavvlad.store.controller;

import glavvlad.store.model.Address;
import glavvlad.store.model.Cart;
import glavvlad.store.model.Customer;
import glavvlad.store.model.Order;
import glavvlad.store.service.CartService;
import glavvlad.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService service;

    @RequestMapping("/order/{cartId}")
    public String create(@PathVariable("cartId") int cartId) {
        Order order = new Order();
        Cart cart = cartService.getById(cartId);
        order.setCart(cart);

        Customer customer = cart.getCustomer();
        order.setCustomer(customer);

        Address address = customer.getAddress();
        order.setAddress(address);

        service.add(order);

        return "redirect:/checkout?cartId="+cartId;
    }
}
