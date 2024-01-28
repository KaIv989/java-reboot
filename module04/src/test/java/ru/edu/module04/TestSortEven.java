package ru.edu.module04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestSortEven {
    @Test
    public void equalsEvent() {

        List<Integer> listNums;
        listNums = new ArrayList<>();
        listNums.add(0);
        listNums.add(2);
        listNums.add(17);
        listNums.add(8);
        listNums.add(10);

        Comparator<Integer> testEven = new CustomDigitComparator();
        listNums.sort(testEven);

        List<Integer> ExpectedResult;
        ExpectedResult = new ArrayList<>();
        ExpectedResult.add(0);
        ExpectedResult.add(2);
        ExpectedResult.add(8);
        ExpectedResult.add(10);
        ExpectedResult.add(17);
        assertEquals(ExpectedResult, listNums);
    }
}
