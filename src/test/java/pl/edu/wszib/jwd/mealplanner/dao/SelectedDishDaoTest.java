package pl.edu.wszib.jwd.mealplanner.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.jwd.mealplanner.model.SelectedDish;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


//@SpringBootTest
//@Transactional
class SelectedDishDaoTest {
//
//    public static final String DISH_TEA = "tea";
//    public static final String DISH_COFFEE = "coffee";
//    public static final int TOTAL_DISH = 3;
//
//
//    @Autowired
//    SelectedDishDao selectedDishDao;
//
//    @BeforeEach
//    void setUp(){
//        SelectedDish selectedDish1 = new SelectedDish(DISH_TEA, new Date());
//        SelectedDish selectedDish2 = new SelectedDish(DISH_COFFEE, new Date());
//        SelectedDish selectedDish3 = new SelectedDish(DISH_COFFEE, new Date());
//
//        assertNull(selectedDish1.getId());
//        assertNull(selectedDish2.getId());
//        assertNull(selectedDish3.getId());
//
//        selectedDishDao.save(selectedDish1);
//        selectedDishDao.save(selectedDish2);
//        selectedDishDao.save(selectedDish3);
//
//        assertNotNull(selectedDish1.getId());
//        assertNotNull(selectedDish2.getId());
//        assertNotNull(selectedDish3.getId());
//
////        selectedDishDao.delete(selectedDish1);
////        selectedDishDao.delete(selectedDish2);
////        selectedDishDao.delete(selectedDish3);
////
////        assertNull(selectedDish1.getId());
////        assertNull(selectedDish2.getId());
////        assertNull(selectedDish3.getId());
//    }
//
//    @Test
//    void testFetchData(){
//        SelectedDish selectedDish = selectedDishDao.findFirstByDish(DISH_COFFEE);
//        assertEquals(DISH_COFFEE, selectedDish.getDish(), "Znaleziono nieprawidłowe danie");
//    }
//
//    @Test
//    void testTetchAllData(){
//        Collection selectedDishes = (Collection)selectedDishDao.findAll();
//        assertEquals(TOTAL_DISH, selectedDishes.size(), "Nieprawidłowa liczba dań");
//    }
//
////    @Test
////    void testTetchAllDataAfterDelate(){
////        Collection selectedDishes = (Collection)selectedDishDao.findAll();
////        assertEquals(TOTAL_DISH, 0, "Nieprawidłowa liczba dań");
////    }

}
