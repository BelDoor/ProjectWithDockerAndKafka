package producer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import producer.domain.Entity.Order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.service.producer.Producer;

@Slf4j
@Service
public class OrderService {

    private final Producer producer;

    @Autowired
    public OrderService(Producer producer) {
        this.producer = producer;
    }

    public void createOrder() throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {
            String item = new String("messeg" + " " + i);
            Double amount = i * 1.2;
            OrderDTO orderDTO = new OrderDTO(item, amount);
            producer.sendMessage(orderDTO);
        }
    }
}
