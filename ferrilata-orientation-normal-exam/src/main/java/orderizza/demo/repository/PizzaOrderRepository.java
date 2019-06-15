package orderizza.demo.repository;

import orderizza.demo.models.PizzaOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaOrderRepository extends CrudRepository<PizzaOrder, Long> {

    @Query(
            value = "SELECT pizza FROM pizza_order GROUP BY pizza ORDER BY COUNT(*) DESC LIMIT 3",
            nativeQuery = true)
    List<String> threeMostOrderedPizzas ();

}
