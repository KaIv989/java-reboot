package ru.sberbank.edu;

public class GCD implements CommonDivisor{
    @Override
    public int getDivisor(int firstNumber, int secondNumber) {

        int gcd = 1;
        for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    }

