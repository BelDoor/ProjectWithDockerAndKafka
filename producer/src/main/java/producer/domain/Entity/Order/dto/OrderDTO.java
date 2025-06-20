package producer.domain.Entity.Order.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class OrderDTO {
    String item;
    Double amount;
}
