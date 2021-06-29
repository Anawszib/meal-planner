package pl.edu.wszib.jwd.mealplanner.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DishControllerTest {

    private static final String DISHES = "dishes";
    private static final String DISH = "dish";
    private static final String NEW_DISH = "newDish";
    private static final String EDIT_DISH = "editDish";
    private static final String REDIRECT_DISHES = "redirect:/dishes";
    private static final String DISHES_TITLE = "Lista dań";
    private static final String DISH_TITLE = "Szczegóły dania";
    private static final String NEW_DISH_TITLE = "Dodaj nowe danie";
    private static final String EDIT_DISH_TITLE = "Edytuj danie";
    public static final int DISH_ID = 1;
    @InjectMocks
    private final DishController controller = new DishController();
    @Mock
    private BindingResult bindingResult;
    @Mock
    private DishService dishService;
    @Mock
    private SelectedDishService selectedDishService;
    @Mock
    private Dish dish;
    @Mock
    private Model model;

    @Test
    public void shouldSetDishesTemplateAttributes() {
        // given
        // when
        String result = controller.dishes(model);
        // then
        verify(model).addAttribute("title", DISHES_TITLE);
        verify(model).addAttribute("dishes", dishService.getAllData());
        assertEquals(DISHES, result);
    }

    @Test
    public void shouldSetDishTemplateAttributes() {
        // given
        String name = "name";
        given(dishService.getDish(name)).willReturn(dish);
        // when
        String result = controller.getDish(name, model);
        // then
        verify(model).addAttribute("title", DISH_TITLE);
        verify(model).addAttribute("dish", dish);
        assertEquals(DISH, result);
    }

    @Test
    public void shouldSetAddNewDishTemplateAttributes() {
        // given
        // when
        String result = controller.addNewDish(model);
        // then
        verify(model).addAttribute("title", NEW_DISH_TITLE);
        assertEquals(NEW_DISH, result);
    }

    @Test
    public void shouldReturnNewDishTemplateWhenErrors() {
        // given
        given(bindingResult.hasErrors()).willReturn(true);
        // when
        String result = controller.postAddNewDish(dish, bindingResult);
        // then
        assertEquals(NEW_DISH, result);
    }

    @Test
    public void shouldReturnNewDishTemplateWhenNotUniqueName() {
        // given
        given(dish.getName()).willReturn(DISH);
        given(dishService.getDish(anyString())).willReturn(dish);
        // when
        String result = controller.postAddNewDish(dish, bindingResult);
        // then
        assertEquals(NEW_DISH, result);
    }

    @Test
    public void shouldReturnDishesTemplateWhenNoErrors() {
        // given
        given(bindingResult.hasErrors()).willReturn(false);
        given(dish.getName()).willReturn(DISH);
        // when
        String result = controller.postAddNewDish(dish, bindingResult);
        // then
        assertEquals(REDIRECT_DISHES, result);
    }

    @Test
    public void shouldSetEditTemplateAttributes() {
        // given
        String name = "name";
        given(dishService.getDish(name)).willReturn(dish);
        // when
        String result = controller.editDish(name, model);
        // then
        verify(model).addAttribute("title", EDIT_DISH_TITLE);
        verify(model).addAttribute("dish", dish);
        assertEquals(EDIT_DISH, result);
    }

    @Test
    public void shouldReturnEditDishTemplateWhenErrors() {
        // given
        given(bindingResult.hasErrors()).willReturn(true);
        // when
        String result = controller.putEditDish(dish, bindingResult);
        // then
        assertEquals(EDIT_DISH, result);
    }

    @Test
    public void shouldReturnEditDishTemplateWhenNotUniqueName() {
        // given
        given(dish.getId()).willReturn(DISH_ID);
        given(dish.getName()).willReturn("name");
        List<String> names = Arrays.asList("name1", "name", "name2");
        given(dishService.findNamesById(DISH_ID)).willReturn(names);
        // when
        String result = controller.putEditDish(dish, bindingResult);
        // then
        assertEquals(EDIT_DISH, result);
    }

    @Test
    public void shouldReturnDishesTemplateWhenNoErrorsEdit() {
        // given
        given(bindingResult.hasErrors()).willReturn(false);
        given(dish.getName()).willReturn(DISH);
        // when
        String result = controller.putEditDish(dish, bindingResult);
        // then
        assertEquals(REDIRECT_DISHES, result);
    }

    @Test
    public void shouldReturnDishesTemplateWhenNoErrorsDelete() {
        // given
        String name = "name";
        given(dishService.getDish(name)).willReturn(dish);
        // when
        String result = controller.removeDish(name);
        // then
        verify(selectedDishService).removeByDish(dish);
        verify(dishService).remove(name);
        assertEquals(REDIRECT_DISHES, result);
    }
}
