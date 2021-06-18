package pl.edu.wszib.jwd.mealplanner.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import java.util.List;

public interface NutritionalValuesDao extends CrudRepository<SelectedDish, Double> {
//Double    List<Double> streamAllByDish_Salt();
}
