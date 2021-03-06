package pl.edu.wszib.jwd.mealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.mealplanner.dao.DishDao;
import pl.edu.wszib.jwd.mealplanner.model.Dish;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishDao dishDao;

    @Override
    public Iterable<Dish> getAllData() {
        return dishDao.findAll();
    }

    @Override
    public Dish getDish(String name) {
        return dishDao.findFirstByName(name);
    }

    @Override
    public Dish getDish(Integer id) {
        return dishDao.findFirstById(id);
    }

    @Override
    @Transactional
    public void save(Dish dish) {
        dishDao.save(dish);
    }

    @Override
    @Transactional
    public void update(Dish dish) {
        dishDao.save(dish);
    }

    @Override
    @Transactional
    public void remove(String name) {
        dishDao.deleteDishByName(name);
    }

    @Override
    public List<String> findNamesById(Integer id) {
        return dishDao.findNamesById(id);
    }
}
