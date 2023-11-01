package ru.sberbank.edu;

/**
 * main
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        GCD gcd = new GCD();
        GreetingImpl hobby = new GreetingImpl();

        System.out.println(hobby.getBestHobby());
        System.out.println(gcd.getDivisor(81, 72));
    }
}
