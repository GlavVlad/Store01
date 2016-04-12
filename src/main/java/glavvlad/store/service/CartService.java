package glavvlad.store.service;

import glavvlad.store.model.Cart;

public interface CartService {

    Cart getById(int id);

    void update(Cart cart);
}
