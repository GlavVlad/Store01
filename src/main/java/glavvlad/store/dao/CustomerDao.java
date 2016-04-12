package glavvlad.store.dao;

import glavvlad.store.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getAll();

    Customer getById(int id);

    Customer getByUsername(String username);

    void add(Customer customer);
}
