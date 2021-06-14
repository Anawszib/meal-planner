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


    @GetMapping({"/select/{dish}", "/select"})
    public String selectDishPage(@PathVariable(required = false) String dish, Model model){

//        if(dish != null){
//            selectedDishService.save(dish);
//        }



        String[][] dishes = {
                {"pierogi ruskie", "pierogi z mięsem", "pierogi z kapustą", "pierogi z grzybami"},
                {"pierogi z truskawkami", "pierogi ze śliwkami","pierogi z borówkami", "pierogi z jabłkami"},
                {"pierogi z serem", "pierogi leniwe", "lazanki", "krokiety"}
        };

        model.addAttribute("title", SELECT_DISH_TITLE);
        model.addAttribute("dishes", dishes);
        return "select";
    }

    @GetMapping({""})
    public String dataPage(Model model){
//        model.addAttribute("title", DATA_TITLE);
        model.addAttribute("selectedDishes", selectedDishService.getAllData());
        return "selectedDishes";
    }

//    @GetMapping({"/stat"})
//    public String statPage(Model model){
//        List<SelectedDish> selectedDishes = (List)selectedDishService.getAllData();
//        Map<String, Long> dataMap = selectedDishes.stream().collect(Collectors.groupingBy(SelectedDish::getDish,Collectors.counting()));
//
//        model.addAttribute("title", STAT_TITLE);
//        model.addAttribute("labels", dataMap.keySet());
//        model.addAttribute("values", dataMap.values());
//
//        return "stat";
//    }

//    @GetMapping({"/"})
//    public String showStartPage(){
//        return "redirect:select";
//    }
}
