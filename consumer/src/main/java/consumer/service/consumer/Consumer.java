package consumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.domain.dto.OrderDto;
import consumer.domain.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final OrderService orderService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, OrderService orderService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.orderService = orderService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
//        log.info("message consumed {}", message);

        OrderDto orderDto = objectMapper.readValue(message, OrderDto.class);
        Order order = modelMapper.map(orderDto, Order.class);

        orderService.persistOrder(order);
    }
}
