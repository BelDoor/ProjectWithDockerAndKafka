package producer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import producer.service.OrderService;

@SpringBootApplication
public class ProducerApplication {

    private static final Logger logger =  LoggerFactory.getLogger(ProducerApplication.class);

    private final OrderService orderService;

    @Autowired
    public Application(OrderService orderService) {
        this.orderService = orderService;
    }


    public void run(String... args) throws Exception {
        orderService.createOrder();
    }

     public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
        logger.info("Running...");
    }



}
