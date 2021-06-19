package pl.edu.wszib.jwd.mealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.mealplanner.dao.NutritionalValuesDao;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NutritionalValuesServiceImpl implements NutritionalValuesService {

    @Autowired
    NutritionalValuesDao nutritionalValuesDao;

    @Autowired
    SelectedDishService selectedDishService;

    public static final Double GDA_ENERGY = 2_000.0;
    public static final Double GDA_PROTEIN = 50.0;
    public static final Double GDA_CARBOHYDRATES = 260.0;
    public static final Double GDA_FAT = 70.0;
    public static final Double GDA_FIBER = 25.0;
    public static final Double GDA_SALT = 6.0;

    @Override
    public Double sumEnergy() {
            return selectedDishService.getAllData().stream()
                    .map(SelectedDish::getDish)
                    .map(Dish::getEnergy)
                    .filter(Objects::nonNull)
                    .mapToDouble(Double::doubleValue)
                    .sum();
    }

    @Override
    public Double sumProtein() {

            return selectedDishService.getAllData().stream()
                    .map(SelectedDish::getDish)
                    .map(Dish::getProtein)
                    .filter(Objects::nonNull)
                    .mapToDouble(Double::doubleValue)
                    .sum();
    }

    @Override
    public Double sumCarbohydrates() {
            return selectedDishService.getAllData().stream()
                    .map(SelectedDish::getDish)
                    .map(Dish::getCarbohydrates)
                    .filter(Objects::nonNull)
                    .mapToDouble(Double::doubleValue)
                    .sum();
    }

    @Override
    public Double sumFat() {

            return selectedDishService.getAllData().stream()
                    .map(SelectedDish::getDish)
                    .map(Dish::getFat)
                    .filter(Objects::nonNull)
                    .mapToDouble(Double::doubleValue)
                    .sum();
    }

    @Override
    public Double sumFiber() {

            return selectedDishService.getAllData().stream()
                    .map(SelectedDish::getDish)
                    .map(Dish::getFiber)
                    .filter(Objects::nonNull)
                    .mapToDouble(Double::doubleValue)
                    .sum();

    }

    @Override
    public Double sumSalt() {

            return selectedDishService.getAllData().stream()
                    .map(SelectedDish::getDish)
                    .map(Dish::getSalt)
                    .filter(Objects::nonNull)
                    .mapToDouble(Double::doubleValue)
                    .sum();
    }

    @Override
    public List<Double> sumNutritionalValues() {
        List<Double> sumNutritionalValuesList = new ArrayList<>();
        sumNutritionalValuesList.add(sumEnergy() / GDA_ENERGY * 100);
        sumNutritionalValuesList.add(sumProtein() / GDA_PROTEIN * 100);
        sumNutritionalValuesList.add(sumCarbohydrates() / GDA_CARBOHYDRATES * 100);
        sumNutritionalValuesList.add(sumFat() / GDA_FAT * 100);
        sumNutritionalValuesList.add(sumFiber() / GDA_FIBER * 100);
        sumNutritionalValuesList.add(sumSalt() / GDA_SALT * 100);

        return sumNutritionalValuesList;
    }
}
