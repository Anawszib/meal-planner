package pl.edu.wszib.jwd.mealplanner.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.edu.wszib.jwd.mealplanner.model.Dish;

import java.util.List;

public interface DishDao extends CrudRepository<Dish, Integer> {
    Dish findFirstById(Integer id);

    Dish findFirstByName(String name);

    void deleteDishByName(String name);

    @Query(value = "SELECT name FROM dishes WHERE cast(id as varchar) <> cast(?1 as varchar) ", nativeQuery = true)
    List<String> findNamesById(Integer id);
}
