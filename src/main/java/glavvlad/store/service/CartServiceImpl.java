package glavvlad.store.service;

import glavvlad.store.dao.CartDao;
import glavvlad.store.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao dao;

    @Override
    public Cart getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void update(Cart cart) {
        dao.update(cart);
    }
}
