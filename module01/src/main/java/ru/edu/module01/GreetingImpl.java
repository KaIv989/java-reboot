package ru.edu.module01;

/**
 * Класс вернет мои хобби
 *
 */
public class GreetingImpl implements Greeting{
    @Override
    public String getBestHobby() {
        return "Меня зовут Иван, мое любимое увлечение: " +
                "1) Прогулка, " +
                "2) Программирование";
    }
}
