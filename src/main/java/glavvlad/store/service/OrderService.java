package glavvlad.store.service;

import glavvlad.store.model.Order;

public interface OrderService {

    void add(Order order);

    double getGrandTotal(int cartId);
}
