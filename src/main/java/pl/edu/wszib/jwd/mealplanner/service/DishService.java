package pl.edu.wszib.jwd.mealplanner.service;

import pl.edu.wszib.jwd.mealplanner.model.Dish;

public interface DishService {
    Iterable<Dish> getAllData();
    Dish getDish(String name);
    void save(Dish dish);
    void update(Dish dish);
    void remove(String name);
}
