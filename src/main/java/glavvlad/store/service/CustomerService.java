package glavvlad.store.service;

import glavvlad.store.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer getById(int id);

    Customer getByUsername(String username);

    void add(Customer customer);

    boolean isEmailUnique(Customer customer);

    boolean isUsernameUnique(Customer customer);

}
