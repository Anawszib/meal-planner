package pl.edu.wszib.jwd.mealplanner.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import pl.edu.wszib.jwd.mealplanner.service.NutritionalValuesService;
import pl.edu.wszib.jwd.mealplanner.service.SelectedDishService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NutritionalValuesControllerTest {

    private static final String NUTRITIONAL_VALUES_TITLE = "Wartości odżywcze";
    public static final String NUTRITIONAL_VALUES = "nutritionalValues";
    @InjectMocks
    private final NutritionalValuesController controller = new NutritionalValuesController();
    @Mock
    private NutritionalValuesService nutritionalValuesService;
    @Mock
    private SelectedDishService selectedDishService;
    @Mock
    private Model model;

    @Test
    public void shouldSetDishesTemplateAttributes() {
        // given
        // when
        String result = controller.nutritionalValues(model);
        // then
        verify(model).addAttribute("title", NUTRITIONAL_VALUES_TITLE);
        verify(model).addAttribute("nutritionalValues", nutritionalValuesService.sumNutritionalValues());
        verify(model).addAttribute("selectedDishes", selectedDishService.getAllData());
        assertEquals(NUTRITIONAL_VALUES, result);
    }
}
