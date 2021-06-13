package pl.edu.wszib.jwd.mealplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;


public interface DishDao extends CrudRepository<Dish, Integer> {
    Dish findFirstByName(String name);



}
