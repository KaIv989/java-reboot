package ru.sberbank.edu;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GCDTest {
    @Test
    public void gcd81_72() {
        GCD gcd = new GCD();
        int ExpectedResult = 9;
        assertEquals(ExpectedResult, gcd.getDivisor(81, 72));
    }

    @Test
    public void gcd72_81() {
        GCD gcd = new GCD();
        int ExpectedResult = 9;
        assertEquals(ExpectedResult, gcd.getDivisor(72, 81));
    }

    @Test
    public void gcd_0_72() {
        GCD gcd = new GCD();
        int ExpectedResult = 1;
        assertEquals(ExpectedResult, gcd.getDivisor(0, 72));
    }

    @Test
    public void gcd_100_100() {
        GCD gcd = new GCD();
        int ExpectedResult = 100;
        assertEquals(ExpectedResult, gcd.getDivisor(100, 100));
    }

}

