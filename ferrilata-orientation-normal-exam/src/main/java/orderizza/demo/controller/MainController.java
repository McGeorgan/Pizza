package orderizza.demo.controller;

import orderizza.demo.models.PizzaOrder;
import orderizza.demo.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    public PizzaOrderRepository pizzaorders;

    @GetMapping("/")
    public String main () {

        return "main";

    }

    @PostMapping("/addorder")
    public String addpizza (@RequestParam String name, @RequestParam String address, @RequestParam String pizza) {

        PizzaOrder order = new PizzaOrder(name,address,pizza);
        pizzaorders.save(order);

        return "redirect:/order/" + order.getId();
    }

    @GetMapping("/order/{id}")
    public String orderpage (Model model, @PathVariable Long id) {

        model.addAttribute("pizza",pizzaorders.findById(id).get());

        return "order";

    }

    @GetMapping("/api/orders/{id}")
    public @ResponseBody
    Optional<PizzaOrder> orderpageapi (@PathVariable long id) {

        Optional<PizzaOrder> pizza = pizzaorders.findById(id);
        return pizza;

    }

   @GetMapping("/stat")
    public String statistics (Model model) {

        model.addAttribute("pizzas",pizzaorders.threeMostOrderedPizzas());
        return "stat";
   }



}
