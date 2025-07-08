package consumer.domain.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class OrderDto {
    String item;
    Double amount;
}
