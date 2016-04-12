package glavvlad.store.dao;

import glavvlad.store.model.Cart;

import java.io.IOException;

public interface CartDao {

    Cart getById(int id);

    void update(Cart cart);

    Cart validate(int id) throws IOException;
}
