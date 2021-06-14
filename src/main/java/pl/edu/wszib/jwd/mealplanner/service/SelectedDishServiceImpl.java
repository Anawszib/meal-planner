package pl.edu.wszib.jwd.mealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.mealplanner.dao.SelectedDishDao;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelectedDishServiceImpl implements SelectedDishService{

    @Autowired
    SelectedDishDao selectedDishDao;

//    @Override
//    @Transactional
//    public void save(SelectedDish selectedDish) {
//        save(selectedDish.getDish().getName());
//    }


    @Override
    @Transactional
    public void add(Dish dish) {
        selectedDishDao.save(new SelectedDish(dish));
    }

    @Override
    @Transactional
    public void remove(Integer id){
        selectedDishDao.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Dish dish) {
        selectedDishDao.save(new SelectedDish(dish));
    }




    @Override
    @Transactional
    public Iterable<SelectedDish> getAllData() {
        return selectedDishDao.findAll();
    }
}
