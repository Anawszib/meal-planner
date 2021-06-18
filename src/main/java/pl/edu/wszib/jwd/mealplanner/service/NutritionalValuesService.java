package pl.edu.wszib.jwd.mealplanner.service;

import java.util.List;

public interface NutritionalValuesService {
    Double sumEnergy();
    Double sumProtein();
    Double sumCarbohydrates();
    Double sumFat();
    Double sumFiber();
    Double sumSalt();
    List<Double> sumNutritionalValues();
}
