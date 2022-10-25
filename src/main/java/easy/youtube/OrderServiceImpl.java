package easy.youtube;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
//    private volatile List<Order> orders;
//    private List<Order> orders;
    private List<Order> orders = new LinkedList<>();

    @Override
    public List<Order> findAll() {
        try {
            lock.readLock().lock();
            return orders;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Order> findLast100() {
        try {
            lock.readLock().lock();
            return orders.stream()
                    .sorted((o1, o2) -> Long.compare(o2.getId(), o1.getId()))
                    .limit(100)
                    .collect(Collectors.toList());
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void add(Order order) {
        try {
            lock.readLock().lock();
            orders.add(order);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public void remove(Order order) {
        try {
            lock.readLock().lock();
            orders.remove(order);
        } finally {
            lock.readLock().unlock();
        }
    }
}
