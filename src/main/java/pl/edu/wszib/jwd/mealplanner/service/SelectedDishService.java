package pl.edu.wszib.jwd.mealplanner.service;

import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

public interface SelectedDishService {
    void add(Dish dish);
    void remove(Integer id);
    void removeAll();
    Iterable<SelectedDish> getAllData();

}
