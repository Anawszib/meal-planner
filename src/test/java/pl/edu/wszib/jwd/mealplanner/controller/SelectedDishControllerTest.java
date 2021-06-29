package pl.edu.wszib.jwd.mealplanner.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import pl.edu.wszib.jwd.mealplanner.model.Dish;
import pl.edu.wszib.jwd.mealplanner.service.DishService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SelectedDishControllerTest {

    private static final String SELECTED_DISHES_TITLE = "Wybrane dania";
    private static final String REDIRECT_DISHES = "redirect:/dishes";
    private static final String REDIRECT_SELECTED_DISH = "redirect:/selected-dish";
    private static final String SELECTED_DISHES = "selectedDishes";
    @InjectMocks
    private final SelectedDishController controller = new SelectedDishController();
    @Mock
    private DishService dishService;
    @Mock
    private SelectedDishService selectedDishService;
    @Mock
    private Dish dish;
    @Mock
    private Model model;

    @Test
    public void shouldReturnDishesTemplateWhenNoErrorsAdd() {
        // given
        String name = "name";
        given(dishService.getDish(name)).willReturn(dish);
        // when
        String result = controller.add(name);
        // then
        verify(selectedDishService).add(dish);
        assertEquals(REDIRECT_DISHES, result);
    }

    @Test
    public void shouldReturnSelectedDishTemplateWhenNoErrorsDelete() {
        // given
        Integer selectedDishId = 1;
        // when
        String result = controller.remove(selectedDishId);
        // then
        verify(selectedDishService).remove(selectedDishId);
        assertEquals(REDIRECT_SELECTED_DISH, result);
    }

    @Test
    public void shouldReturnSelectedDishTemplateWhenNoErrorsDeleteByDish() {
        // given
        String dishName = "name";
        given(dishService.getDish(dishName)).willReturn(dish);
        // when
        String result = controller.removeByDish(dishName);
        // then
        verify(selectedDishService).removeByDish(dish);
        assertEquals(REDIRECT_SELECTED_DISH, result);
    }

    @Test
    public void shouldReturnSelectedDishTemplateWhenNoErrorsDeleteAll() {
        // given
        // when
        String result = controller.removeAll();
        // then
        verify(selectedDishService).removeAll();
        assertEquals(REDIRECT_SELECTED_DISH, result);
    }

    @Test
    public void shouldSetDishesTemplateAttributes() {
        // given
        // when
        String result = controller.dataPage(model);
        // then
        verify(model).addAttribute("title", SELECTED_DISHES_TITLE);
        verify(model).addAttribute("selectedDishes", selectedDishService.getAllData());
        assertEquals(SELECTED_DISHES, result);
    }
}
