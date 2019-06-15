package orderizza.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String address;
    String pizza;

    public PizzaOrder() {
    }

    public PizzaOrder(String name, String address, String pizza) {
        this.name = name;
        this.address = address;
        this.pizza = pizza;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPizza() {
        return pizza;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
}
