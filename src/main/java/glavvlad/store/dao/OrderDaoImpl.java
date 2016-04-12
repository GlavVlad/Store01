package glavvlad.store.dao;

import glavvlad.store.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
        session.flush();
    }

}
