package producer.domain.Order.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String item;
    private Double amount;

    public OrderDTO() {
    }

    public OrderDTO(String item, Double amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
