package glavvlad.store.service;

import glavvlad.store.dao.CartItemDao;
import glavvlad.store.model.Cart;
import glavvlad.store.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemDao dao;

    @Override
    public void add(CartItem item) {
        dao.add(item);
    }

    @Override
    public void delete(CartItem item) {
        dao.delete(item);
    }

    @Override
    public void deleteAll(Cart cart) {
        dao.deleteAll(cart);
    }

    @Override
    public CartItem get(int productId, int cartId) {
        return dao.get(productId, cartId);
    }
}
