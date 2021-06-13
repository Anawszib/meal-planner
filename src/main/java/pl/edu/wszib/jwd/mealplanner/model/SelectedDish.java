package pl.edu.wszib.jwd.mealplanner.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SelectedDishes")
public class SelectedDish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Dish dish;


    public SelectedDish() {
    }

    public SelectedDish(Dish dish) {
        this.dish = dish;
    }

    public SelectedDish(Integer id, Dish dish) {
        this.id = id;
        this.dish = dish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
