package consumer.service.consumer;

import consumer.domain.entity.Order;
import consumer.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void persistOrder(Order order) {
        Order persistedOrder = orderRepository.save(order);
    }
}
