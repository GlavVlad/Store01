package glavvlad.store.service;

import glavvlad.store.dao.OrderDao;
import glavvlad.store.model.Cart;
import glavvlad.store.model.CartItem;
import glavvlad.store.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao dao;
    @Autowired
    private CartService cartService;

    @Override
    public void add(Order order) {
        dao.add(order);
    }

    @Override
    public double getGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getById(cartId);
        List<CartItem> cartItems = cart.getItems();

//        for (CartItem item : cartItems) {
//            grandTotal += item.getTotalPrice();
//        }

        return cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
