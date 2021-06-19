package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.NewDishService;

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
        model.addAttribute("title", NEW_DISH_TITLE);
        return "newDish";
    }

    @PostMapping("")
    public String postAddNewDish(@RequestParam String name, @RequestParam Double energy, @RequestParam Double protein,
                                 @RequestParam Double carbohydrates, @RequestParam Double fat,
                                 @RequestParam Double fiber, @RequestParam Double salt, @RequestParam String image,
                                 @RequestParam String source){
        newDishService.save(new Dish(name, energy, protein, carbohydrates, fat, fiber, salt, image, source));
        return "redirect:/dishes";
    }
}
