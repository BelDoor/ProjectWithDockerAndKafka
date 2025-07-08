package producer.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import producer.domain.Order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(OrderDTO orderDTO) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(orderDTO);
        kafkaTemplate.send(orderTopic, orderAsMessage);

       // log.info("food order produced {}", orderAsMessage);
    }

}
