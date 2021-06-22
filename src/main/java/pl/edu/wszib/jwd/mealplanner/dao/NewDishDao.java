package pl.edu.wszib.jwd.mealplanner.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.jwd.mealplanner.model.Dish;

public interface NewDishDao extends JpaRepository<Dish, Integer> {




}
