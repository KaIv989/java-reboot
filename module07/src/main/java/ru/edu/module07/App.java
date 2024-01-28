package ru.edu.module07;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        WeatherCache wc = new WeatherCache(new WeatherProvider());

        Runnable task = () -> {
            try {
                System.out.println("=============================");
                // Кидаем запрос в API на получение погоды в Ростове.
                wc.getWeatherInfo("Rostov-on-Don");
                // Засыпаем на минуту.
                System.out.println("Thread fell asleep for 60 seconds...");
                Thread.sleep(60000);
                System.out.println("=============================");
                // Просыпаемся. Кэш еще актуален.
                System.out.println("Thread woke up!");
                // Запрашиваем погоду из кэша.
                wc.getWeatherInfo("Rostov-on-Don");
                // Засыпаем на 6 минут, чтобы кэш "протух".
                System.out.println("Thread fell asleep for 360 seconds...");
                Thread.sleep(360000);
                System.out.println("=============================");
                // Просыпаемся. Кэш уже не актуален.
                System.out.println("Thread woke up!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread myThread = new Thread(task);
        myThread.start();
    }
}
