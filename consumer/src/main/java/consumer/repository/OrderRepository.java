package consumer.repository;

import consumer.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrederRepository extends JpaRepository<Order, Long> {
}
