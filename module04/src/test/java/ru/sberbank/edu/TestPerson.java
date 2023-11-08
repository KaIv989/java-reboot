package ru.sberbank.edu;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerson {
    @Test
    public void equalsPerson() {
        Person person1 = new Person("Alex", "Rostov", 44);
        Person person2 = new Person("alex", "rostov", 44);
        assertEquals(person1, person2);
        assertNotEquals(person1.hashCode(), person2.hashCode());
        Person person3 = new Person("Alex", "Rostov", 44);
        Person person4 = new Person("alex", "rostov", 34);
        assertNotEquals(person3, person4);

    }
    @Test
    public void comparablePerson() {
        Person person1 = new Person("Alex", "Rostov", 44);
        Person person2 = new Person("alex", "rostov", 44);
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

        List<Person> personsExpected = new ArrayList<>();
        personsExpected.add(person4);
        personsExpected.add(person3);
        personsExpected.add(person1);
        personsExpected.add(person5);
        personsExpected.add(person2);

        assertEquals(personsExpected, persons);
    }
}
