package glavvlad.store.dao;

import glavvlad.store.model.Cart;
import glavvlad.store.service.OrderService;
import glavvlad.store.service.OrderServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private OrderService orderService;

    @Override
    public Cart getById(int id) {
        Session session = sessionFactory.getCurrentSession();
//        em.find(Cart.class, id);
        return session.get(Cart.class, id);
    }

    @Override
    public void update(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        cart.setGrandTotal(orderService.getGrandTotal(cart.getId()));
        session.saveOrUpdate(cart);
        session.flush();

    }

    @Override
    public Cart validate(int id) throws IOException {
        Cart cart = getById(id);
        if (cart == null && cart.getItems().size() == 0) {
            throw new IOException();
        }

        update(cart);

        return cart;
    }
}
