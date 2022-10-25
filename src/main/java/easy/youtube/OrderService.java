package easy.youtube;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    List<Order> findLast100();

    void add(Order order);

    void remove(Order order);
}
