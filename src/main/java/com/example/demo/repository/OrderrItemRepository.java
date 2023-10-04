package repository;

import entity.OrderrItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderrItemRepository extends JpaRepository<OrderrItem, Integer> {
}
