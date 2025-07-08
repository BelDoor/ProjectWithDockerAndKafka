package producer.domain.Order.dto;

import lombok.Data;

@Data
public class OrderDTO {
    String item;
    Double amount;

    public OrderDTO(String item, Double amount) {
        this.item = item;
        this.amount = amount;
    }
}
