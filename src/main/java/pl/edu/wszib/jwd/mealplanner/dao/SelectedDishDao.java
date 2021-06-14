package pl.edu.wszib.jwd.mealplanner.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

@Repository
public interface SelectedDishDao extends CrudRepository<SelectedDish, Integer> {
    SelectedDish findFirstByDishName(String dishName);
    void deleteByDishName(String dishName);

}
