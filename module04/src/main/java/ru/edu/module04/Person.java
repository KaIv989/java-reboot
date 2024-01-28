package ru.edu.module04;

/**
 *  Задание №2
 *  Реализовать класс Person{name, city, age}, определить метод toString.
 *  Реализовать методы equals и hashCode (Условие равенства: все поля name, city, age должны совпадать, name и city без учета регистра).
 *  Класс Person должен реализовывать интерфейс Comparable<Person>, который обеспечивает следующий порядок:
 *  Сортировка сначала по полю city, а затем по полю name.
 *  Поля city, name отличны от null.
 */
public class Person implements Comparable<Person>{

    final String name;
    private final String city;
    private final Integer age;


    public Person(String name, String city, Integer age){
        this.name = name;
        this.city = city;
        this.age = age;

    }
    @Override
    public String toString() {
        return "name: " + name + ", city: " + city + ", age = " + age;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        String personObj = person.toString().toLowerCase();
        String personThis = this.toString().toLowerCase();
        return personThis.equals(personObj);
    }
    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + (city == null ? 0 : city.hashCode());
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Person personObj) {

        if(city.equals(personObj.city))
            return name.compareTo(personObj.name);
        return city.compareTo(personObj.city);
    }


}
