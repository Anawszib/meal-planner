package pl.edu.wszib.jwd.mealplanner.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import java.util.List;

@Repository
public interface SelectedDishDao extends CrudRepository<SelectedDish, Integer> {
List<SelectedDish> findAll();
void deleteAllByDish(Dish dish);
}
