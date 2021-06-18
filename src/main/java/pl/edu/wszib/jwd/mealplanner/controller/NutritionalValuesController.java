package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;
import pl.edu.wszib.jwd.mealplanner.service.NutritionalValuesService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
@RequestMapping("nutritional-values")
public class NutritionalValuesController {

    @Autowired
    NutritionalValuesService nutritionalValuesService;

    public static final String NUTRITIONAL_VALUES_TITLE = "Wartości odżywcze";

    @GetMapping({""})
    public String nutritionalValues(Model model){
        model.addAttribute("title", NUTRITIONAL_VALUES_TITLE);
        model.addAttribute("nutritionalValues", nutritionalValuesService.sumNutritionalValues());
        return "nutritionalValues";

    }
}
