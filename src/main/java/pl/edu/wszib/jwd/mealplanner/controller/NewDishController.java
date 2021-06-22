package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.NewDishService;

import javax.validation.Valid;

@Controller
@RequestMapping("add-new-dish")
public class NewDishController {

    @Autowired
    DishService dishService;

    @Autowired
    NewDishService newDishService;

    public static final String NEW_DISH_TITLE = "Dodaj nowe danie";

    @GetMapping("")
    public String addNewDish(Model model){
        Dish dish = new Dish();

        model.addAttribute("title", NEW_DISH_TITLE);
        model.addAttribute("dish",dish);

        return "newDish";
    }

    @PostMapping("")
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

        newDishService.save(dish);
        return "redirect:/dishes";
    }
}
