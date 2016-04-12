package glavvlad.store.service;

import glavvlad.store.dao.CustomerDao;
import glavvlad.store.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao dao;

    @Override
    public List<Customer> getAll() {
        return dao.getAll();
    }

    @Override
    public Customer getById(int id) {
        return dao.getById(id);
    }

    @Override
    public Customer getByUsername(String username) {
        return dao.getByUsername(username);
    }

    @Override
    public void add(Customer customer) {
        dao.add(customer);
    }

    @Override
    public boolean isEmailUnique(Customer customer) {
        List<Customer> customers = getAll();

        for (Customer customerInDb : customers) {
            if (customerInDb.getEmail().equals(customer.getEmail())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isUsernameUnique(Customer customer) {
        List<Customer> customers = getAll();

        for (Customer customerInDb : customers) {
            if (customerInDb.getUsername().equals(customer.getUsername())) {
                return false;
            }
        }
        return true;
    }
}
