package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;


@Controller
public class DishController {

    @Autowired
    DishService dishService;

    @Autowired
    SelectedDishService selectedDishService;

    public static final String DISHES_TITLE = "Lista dań";
    public static final String DISH_TITLE = "Szczegóły dania";

    @GetMapping({"","/dishes"})
    public String dishes(Model model){

        model.addAttribute("title", DISHES_TITLE);
        model.addAttribute("dishes", dishService.getAllData());
        return "dishes";

    }

    @GetMapping("dish/{name}")
    public String getDish(@PathVariable String name, Model model){
        model.addAttribute("title", DISH_TITLE);
        model.addAttribute("dish",dishService.getDish(name));
        return "dish";
    }
}
