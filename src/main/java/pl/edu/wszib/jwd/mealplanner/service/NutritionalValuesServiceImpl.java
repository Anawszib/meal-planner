package pl.edu.wszib.jwd.mealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import java.util.List;

@Service
public class NutritionalValuesServiceImpl implements NutritionalValuesService {

    @Autowired
    SelectedDishService selectedDishService;

    @Override
    public Double sumEnergy(){
        return selectedDishService.getAllData().stream()
                .map(SelectedDish::getDish)
                .map(Dish::getEnergy)
                .mapToDouble(Double::doubleValue)
                .sum();

    }


}
