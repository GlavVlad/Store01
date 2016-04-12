package glavvlad.store.dao;

import glavvlad.store.model.Cart;
import glavvlad.store.model.CartItem;

public interface CartItemDao {

    void add(CartItem item);

    void delete(CartItem item);

    void deleteAll(Cart cart);

    CartItem get(int productId, int cartId);
}
