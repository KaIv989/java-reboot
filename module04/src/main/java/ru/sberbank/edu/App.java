package ru.sberbank.edu;

import java.util.*;

/**
 * Задание №1
 * Написать компаратор CustomDigitComparator, который реализует интерфейс Comparator<Integer>.
 * Класс CustomDigitComparator определяет следующий порядок:
 * Сначала четные числа, затем нечетные
 * На вход подаются числа, отличные от null.
 * Задание №2
 * Реализовать класс Person{name, city, age}, определить метод toString.
 * Реализовать методы equals и hashCode (Условие равенства: все поля name, city, age должны совпадать, name и city без учета регистра).
 * Класс Person должен реализовывать интерфейс Comparable<Person>, который обеспечивает следующий порядок:
 * Сортировка сначала по полю city, а затем по полю name.
 * Поля city, name отличны от null.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        task1();
        task2();
    }
    public static void task1(){
        List<Integer> nums;
        nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(15);
        nums.add(8);
        nums.add(10);
        nums.add(7);
        Comparator<Integer> even = new CustomDigitComparator();
        nums.sort(even);
        System.out.println( nums );
    }
    public static void task2(){
        Person person1 = new Person("Alex", "Rostov", 44);
        System.out.println( person1);
        System.out.println("hashCode = " + person1.hashCode());
        Person person2 = new Person("alex", "rostov", 44);
        System.out.println( person2);
        System.out.println("hashCode = " + person2.hashCode());
        System.out.println( "equals = " + person1.equals(person2) );

        Person person3 = new Person("Alex", "Moscow", 44);
        Person person4 = new Person("zic", "Anapa", 44);
        Person person5 = new Person("bob", "Rostov", 44);
        List<Person> persons = new ArrayList<>();
        persons.add(person5);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        Collections.sort(persons);
        System.out.println( "Comparable " + persons );

    }
}
