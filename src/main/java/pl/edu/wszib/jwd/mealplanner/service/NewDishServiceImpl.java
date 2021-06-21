package pl.edu.wszib.jwd.mealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.mealplanner.dao.DishDao;
import pl.edu.wszib.jwd.mealplanner.dao.NewDishDao;
import pl.edu.wszib.jwd.mealplanner.model.Dish;

import javax.transaction.Transactional;

@Service
public class NewDishServiceImpl implements NewDishService{

    @Autowired
    NewDishDao newDishDao;

    @Override
    @Transactional
    public void save(Dish newDish) {
        newDishDao.save(newDish);
    }
}
