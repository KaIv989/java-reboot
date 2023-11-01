package ru.sberbank.edu;


/**
 * Класс вернет наибольший общий делитель 2х чисел. (Алгоримт Евклида с использованием рекурсии)
 *
 */
public class GCD implements CommonDivisor{
    @Override
    public int getDivisor(int firstNumber, int secondNumber) {

        if (secondNumber == 0) {
            return firstNumber;
        }
        return getDivisor(secondNumber, firstNumber % secondNumber);
    }
    }

