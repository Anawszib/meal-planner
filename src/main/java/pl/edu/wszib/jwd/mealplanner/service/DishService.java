package pl.edu.wszib.jwd.mealplanner.service;

import pl.edu.wszib.jwd.mealplanner.model.Dish;

import java.util.List;

public interface DishService {
    Iterable<Dish> getAllData();

    Dish getDish(String name);

    Dish getDish(Integer id);

    void save(Dish dish);

    void update(Dish dish);

    void remove(String name);

    List<String> findNamesById(Integer id);

}
