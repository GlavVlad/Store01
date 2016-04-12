package glavvlad.store.service;

import glavvlad.store.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    List<Product> getByCategory(String category);

    Product getById(int id);

    void addOrEdit(Product product);

    void delete(Product product);
}
