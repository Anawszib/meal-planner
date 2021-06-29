package pl.edu.wszib.jwd.mealplanner.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.jwd.mealplanner.model.Dish;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
class DishDaoTest {
    @Autowired
    DishDao dishDao;

    @AfterEach
    @Transactional
    public void clean() {
        dishDao.deleteAll();
    }

    @Test
    @Transactional
    public void shouldNotReturnNameFromDishWithGivenId() {
        // given
        Dish dish1 = createAndAddDish(1, "name1");
        Dish dish2 = createAndAddDish(2, "name2");
        Dish dish3 = createAndAddDish(3, "name3");
        // when
        List<String> result = dishDao.findNamesById(1);
        // then
        assertFalse(result.contains("name1"));
    }

    @Test
    @Transactional
    public void shouldReturnAllNames() {
        // given
        Dish dish1 = createAndAddDish(4, "name1");
        Dish dish2 = createAndAddDish(5, "name2");
        Dish dish3 = createAndAddDish(6, "name3");
        // when
        List<String> result = dishDao.findNamesById(44);
        // then
        assertEquals(3, result.size());
    }

    private Dish createAndAddDish(int id, String name) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setName(name);
        dishDao.save(dish);
        return dish;
    }
}
