package pl.edu.wszib.jwd.mealplanner.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionControllerTest {

    private static final String ERROR = "error";
    @InjectMocks
    private final ExceptionController controller = new ExceptionController();

    @Test
    public void shouldSetDishesTemplateAttributes() {
        // given
        // when
        String result = controller.showError();
        // then
        assertEquals(ERROR, result);
    }

}
