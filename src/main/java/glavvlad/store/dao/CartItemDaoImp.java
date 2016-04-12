package glavvlad.store.dao;

import glavvlad.store.model.Cart;
import glavvlad.store.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImp implements CartItemDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(CartItem item) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(item);
        session.flush();
    }

    @Override
    public void delete(CartItem item) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(item);
        session.flush();
    }

    @Override
    public void deleteAll(Cart cart) {
        List<CartItem> cartItems = cart.getItems();

        cartItems.forEach(this::delete);
    }

    @Override
    public CartItem get(int productId, int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = ? and cartId = ?");
        query.setInteger(0, productId);
        query.setInteger(1, cartId);
        return (CartItem) query.uniqueResult();
//        return session.get(CartItem.class, productId);
    }
}
