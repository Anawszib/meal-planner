package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;

@Controller
@RequestMapping("selected-dish")
public class SelectedDishController {

    @Autowired
    SelectedDishService selectedDishService;
    @Autowired
    DishService dishService;

    public static final String SELECT_DISH_TITLE = "Wybierz danie";
    public static final String DATA_TITLE = "Dane";
    public static final String STAT_TITLE = "Statystyki";

    @GetMapping("add/{dishName}")
    public String add(@PathVariable String dishName) {
        Dish dish = dishService.getDish(dishName);
        selectedDishService.add(dish);
        return "redirect:/dishes";
    }

    @GetMapping("remove/{selectedDishId}")
    public String remove(@PathVariable Integer selectedDishId){
        selectedDishService.remove(selectedDishId);
        return "redirect:/selected-dish";
    }




    @GetMapping({""})
    public String dataPage(Model model){
        model.addAttribute("selectedDishes", selectedDishService.getAllData());
        return "selectedDishes";
    }


}
