package ru.sberbank.edu;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
        * Hello Тест!
        *
        */
public class TestCustomArrayImpl {
    @Test
    public void equalsArray() {
        CustomArrayImpl<String> arrayList = new CustomArrayImpl<>(2);
        assertEquals(arrayList.getCapacity(), 2);
        Integer[] list = new Integer[] {1,2,3,4,5};
        arrayList.add(11);
        assertEquals(arrayList.getCapacity(), 2);
        assertEquals(arrayList.size(), 1);
        arrayList.add(22);
        assertEquals(arrayList.getCapacity(), 2);
        arrayList.add(33);
        arrayList.add(44);
        arrayList.add(55);
        assertEquals(arrayList.getCapacity(), 5);
        assertEquals(arrayList.size(), 5);

        arrayList.remove(3);
        assertEquals(arrayList.getCapacity(), 5);
        assertEquals(arrayList.size(), 4);
        arrayList.addAll(2, list);
        assertEquals(arrayList.getCapacity(), 10);
        assertEquals(arrayList.size(), 9);
        assertEquals(arrayList.indexOf(null), 9);


    }

}
