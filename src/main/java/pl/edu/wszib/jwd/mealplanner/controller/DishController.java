package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class DishController {

//    private final DishService dishService;
//
//    @Autowired
//    public DishController(DishService dishService){
//        this.dishService = dishService;
//    }

    @Autowired
    DishService dishService;

    @Autowired
    SelectedDishService selectedDishService;

    public static final String DISH_TITLE = "Wybierz danie";

    @GetMapping({"","/dishes"})
    public String dishes(Model model){

//        if(dish != null){
//            selectedDishService.save(dish);
//        }

        model.addAttribute("title", DISH_TITLE);
        model.addAttribute("dishes", dishService.getAllData());
        return "dishes";





    }
}
