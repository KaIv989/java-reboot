package ru.edu.module01;

/**
 * Тест GreetingImpl
 *
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingImplTest {
    @Test
    public void hobby() {
        GreetingImpl hobby = new GreetingImpl();
        String res = "Меня зовут Иван, мое любимое увлечение: " +
                "1) Прогулка, " +
                "2) Программирование";
        assertEquals(res, hobby.getBestHobby());
    }
}
