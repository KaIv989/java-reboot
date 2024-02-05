package ru.edu.module05;

/**
 * Hello world!
 *
 */

public class App
{
    public static void main( String[] args )
    {
        CityInfo citiInfo1 = new CityInfo("Rostov", new GeoPosition("55(45'07'')", "59(57'00'')"));
        CityInfo citiInfo2 = new CityInfo("Omsk", new GeoPosition("80(29'00'')", "40(37'45'')"));
        TravelService tr = new TravelService();
        tr.add(citiInfo1);
        tr.add(citiInfo2);
        System.out.println(tr.citiesNames());
        tr.remove("Omsk");
        System.out.println(tr.citiesNames());
        tr.add(citiInfo2);
        System.out.println(tr.getDistance("Rostov", "Omsk"));
        System.out.println(tr.getCitiesNear("Rostov", 2978066));


    }
}