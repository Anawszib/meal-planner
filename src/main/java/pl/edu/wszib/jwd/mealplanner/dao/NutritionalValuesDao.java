package pl.edu.wszib.jwd.mealplanner.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

public interface NutritionalValuesDao extends CrudRepository<SelectedDish, Double> {
}
