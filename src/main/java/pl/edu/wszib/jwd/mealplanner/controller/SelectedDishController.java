package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    public static final String SELECTED_DISHES_TITLE = "Wybrane dania";

//    @PostMapping("/add")
//    public String add(Dish dish) {
//        selectedDishService.add(dish);
//        return "redirect:/dishes";
//    }


    @GetMapping("add/{dishName}")
    public String add(@PathVariable String dishName) {
        Dish dish = dishService.getDish(dishName);
        selectedDishService.add(dish);
        return "redirect:/dishes";
    }

    @DeleteMapping("{id}")
    public String remove(@PathVariable("id") Integer selectedDishId) {
        selectedDishService.remove(selectedDishId);
        return "redirect:/selected-dish";
    }

    @DeleteMapping("remove-by-name/{dishName}")
    public String removeByDish(@PathVariable String dishName) {
        Dish dish = dishService.getDish(dishName);
        selectedDishService.removeByDish(dish);
        return "redirect:/selected-dish";
    }

    @DeleteMapping("")
    public String removeAll() {
        selectedDishService.removeAll();
        return "redirect:/selected-dish";
    }

    @GetMapping({""})
    public String dataPage(Model model) {
        model.addAttribute("title", SELECTED_DISHES_TITLE);
        model.addAttribute("selectedDishes", selectedDishService.getAllData());
        return "selectedDishes";
    }
}
