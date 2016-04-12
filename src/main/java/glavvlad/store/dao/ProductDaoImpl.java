package glavvlad.store.dao;

import glavvlad.store.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");

        return query.list();
    }

    @Override
    public List<Product> getByCategory(String category) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where Category = ?");
        query.setString(0, category);

        return query.list();
    }

    public Product getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Product.class, id);
    }

    public void addOrEdit(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
