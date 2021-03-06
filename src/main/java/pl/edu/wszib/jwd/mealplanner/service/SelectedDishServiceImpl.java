package pl.edu.wszib.jwd.mealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.mealplanner.dao.SelectedDishDao;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SelectedDishServiceImpl implements SelectedDishService {

    @Autowired
    SelectedDishDao selectedDishDao;

    @Override
    @Transactional
    public void add(Dish dish) {
        selectedDishDao.save(new SelectedDish(dish));
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        selectedDishDao.deleteById(id);
    }

    @Override
    @Transactional
    public void removeByDish(Dish dish) {
        selectedDishDao.deleteAllByDish(dish);
    }

    @Override
    @Transactional
    public void removeAll() {
        selectedDishDao.deleteAll();
    }

    @Override
    @Transactional
    public List<SelectedDish> getAllData() {
        return selectedDishDao.findAll();
    }
}
