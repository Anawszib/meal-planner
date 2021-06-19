package pl.edu.wszib.jwd.mealplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String showError(){
        return "error";
    }
}
