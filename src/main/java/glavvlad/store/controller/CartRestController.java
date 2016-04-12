package glavvlad.store.controller;

import glavvlad.store.model.Cart;
import glavvlad.store.model.CartItem;
import glavvlad.store.model.Customer;
import glavvlad.store.model.Product;
import glavvlad.store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/rest/cart")
public class CartRestController {

    @Autowired
    private CartService service;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/{id}")
    public Cart getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable("productId") int productId, @AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getById(productId);
        List<CartItem> cartItems = cart.getItems();

//        cartItems.stream().filter(cartItem -> product.getId() == cartItem.getId()).forEach(cartItem -> {
//            cartItem.setQuantity(cartItem.getQuantity() + 1);
//            cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
//            cartItemService.add(cartItem);
//        });

        for (CartItem cartItem : cartItems) {
            if (product.getId() == cartItem.getProduct().getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
                cartItemService.add(cartItem);
                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getPrice());
        cartItem.setCart(cart);
        cartItemService.add(cartItem);
    }

    @RequestMapping(value = "/{cartId}/delete/{productId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("productId") int productId, @PathVariable("cartId") int cartId) {
        CartItem cartItem = cartItemService.get(productId, cartId);
        cartItemService.delete(cartItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clear(@PathVariable("id") int id) {
        Cart cart = service.getById(id);
        cartItemService.deleteAll(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad Request")
    public void handlerClientErrors(Exception e) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handlerServerErrors(Exception e) {
    }
}
