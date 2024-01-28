package ru.edu.module05;
import org.junit.Assert;
import org.junit.Test;

/**
 * Тесты module05
 */
public class AppTest
{
    @Test
    public void testTravelService()
    {
        TravelService tr = new TravelService();
        tr.add(new CityInfo("Moscow", new GeoPosition("22(44'22'')", "33(55'35'')")));
        tr.add(new CityInfo("Piter", new GeoPosition("11(66'24'')", "77(44'23'')")));
        tr.add(new CityInfo("Rostov", new GeoPosition("56(57'00'')", "35(46'54'')")));


        /**
         * Проверка метода remove
         */
        tr.remove("Rostov");
        Assert.assertEquals(tr.citiesNames().size(), 2);

        tr.add(new CityInfo("Rostov", new GeoPosition("56(57'00'')", "35(46'54'')")));
        /**
         * Проверка метода getDistance
         */
        Assert.assertEquals(tr.getDistance("Moscow", "Piter"), 12258757);

        /**
         * Проверка метода getCitiesNear
         */
        Assert.assertEquals(tr.getCitiesNear("Rostov", 11188888).size(), 1 );


    }
}