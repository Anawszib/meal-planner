package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;

import javax.validation.Valid;


@Controller
public class DishController {

    @Autowired
    DishService dishService;

    @Autowired
    SelectedDishService selectedDishService;

    public static final String DISHES_TITLE = "Lista dań";
    public static final String DISH_TITLE = "Szczegóły dania";
    public static final String NEW_DISH_TITLE = "Dodaj nowe danie";

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

    @GetMapping("add-new-dish")
    public String addNewDish(Model model){
        Dish dish = new Dish();
        model.addAttribute("title", NEW_DISH_TITLE);
        model.addAttribute("dish",dish);

        return "newDish";
    }

    @PostMapping("add-new-dish")
    public String postAddNewDish(@Valid Dish dish, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "newDish";
        }

        if(dishService.getDish(dish.getName()) != null){
            FieldError error = new FieldError("dish", "name",
                    "Danie o podanej nazwie już istnieje");
            bindingResult.addError(error);
            return "newDish";
        }

        dishService.save(dish);
        return "redirect:/dishes";
    }

    @GetMapping("dish/remove-dish/{name}")
    public String removeDish(@PathVariable String name){
        Dish dish = dishService.getDish(name);
        selectedDishService.removeByDish(dish);
        dishService.remove(name);
        return "redirect:/dishes";
    }

}
