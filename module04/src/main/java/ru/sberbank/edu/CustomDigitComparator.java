package ru.sberbank.edu;

import java.util.Comparator;

/**
 * Задание №1
 * Написать компаратор CustomDigitComparator, который реализует интерфейс Comparator<Integer>.
 * Класс CustomDigitComparator определяет следующий порядок:
 * Сначала четные числа, затем нечетные
 * На вход подаются числа, отличные от null.

 */
public class CustomDigitComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {

        return (o1 % 2 - o2 % 2);
    }
}
