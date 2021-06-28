package pl.edu.wszib.jwd.mealplanner.service;

import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import java.util.List;

public interface SelectedDishService {
    void add(Dish dish);

    void remove(Integer id);

    void removeByDish(Dish dish);

    void removeAll();

    List<SelectedDish> getAllData();

}
