package glavvlad.store.service;

import glavvlad.store.dao.ProductDao;
import glavvlad.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getByCategory(String category) {
        return productDao.getByCategory(category);
    }

    @Override
    public Product getById(int id) {
        return productDao.getById(id);
    }

    @Override
    public void addOrEdit(Product product) {
        productDao.addOrEdit(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }
}
