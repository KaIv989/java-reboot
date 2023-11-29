package ru.sberbank.edu;
import java.util.ArrayList;
import java.util.List;

/**
 * Travel Service.
 */
public class TravelService {

    private final List<CityInfo> cities = new ArrayList<>();

    /**
     * Append city info.
     *
     * @param cityInfo - city info
     * @throws IllegalArgumentException if city already exists
     */
    public void add(CityInfo cityInfo) {
        if (cities.stream().filter(c->c.getName().equals(cityInfo.getName())).toList().size() != 0){
            throw new IllegalArgumentException("if city already exists");
        }
        else {cities.add(cityInfo);}
    }

    /**
     * remove city info.
     *
     * @param cityName - city name
     * @throws IllegalArgumentException if city doesn't exist
     */
    public void remove(String cityName) {

        if (cities.stream().filter(c->c.getName().equals(cityName)).toList().size() == 0){
            throw new IllegalArgumentException("if city doesn't exist");}

        else{cities.removeIf(c -> cityName.equalsIgnoreCase(c.getName()));}

//        this.cities.stream().map((cityInfo) -> {
//            if (cityInfo.getters().containsKey(cityName)) {
//                cityInfo.getters().remove(cityName);
//
//            }else {
//                throw new IllegalArgumentException("if city doesn't exist");
//            }
//            return this.cities;
//        });
        // do something
    }

    /**
     * Get cities names.
     */
    public List<String> citiesNames() {
        return cities.stream().map(CityInfo::getName).toList();
    }

    /**
     * Get distance in kilometers between two cities.
     * https://www.kobzarev.com/programming/calculation-of-distances-between-cities-on-their-coordinates/
     *
     * @param srcCityName  - source city
     * @param destCityName - destination city
     * @throws IllegalArgumentException if source or destination city doesn't exist.
     */
    public int getDistance(String srcCityName, String destCityName) {

        if (!this.citiesNames().contains(srcCityName) && !this.citiesNames().contains(destCityName)){
            throw new IllegalArgumentException("if source or destination city doesn't exist.");}

        // Радиус земли
        final double EARTH_RADIUS = 6372795;

        double srcLatitude = 0, srcLongitude = 0, destLatitude = 0, destLongitude = 0;

        List<CityInfo> src = cities.stream().filter(CityInfo -> CityInfo.getName().equals(srcCityName)).toList();
        srcLatitude = src.get(0).getters().get(srcCityName).getters()[0];
        srcLongitude = src.get(0).getters().get(srcCityName).getters()[1];

        List<CityInfo> dest = cities.stream().filter(CityInfo -> CityInfo.getName().equals(destCityName)).toList();
        destLatitude = dest.get(0).getters().get(destCityName).getters()[0];
        destLongitude = dest.get(0).getters().get(destCityName).getters()[1];

        double cl1 = Math.cos(srcLatitude);
        double cl2 = Math.cos(destLatitude);
        double sl1 = Math.sin(srcLatitude);
        double sl2 = Math.sin(destLatitude);
        double delta = destLongitude - srcLongitude;
        double cdelta = Math.cos(delta);
        double sdelta = Math.sin(delta);

        // вычисления длины большого круга
        double y = Math.sqrt(Math.pow(cl2 * sdelta, 2) + Math.pow(cl1 * sl2 - sl1 * cl2 * cdelta, 2));
        double x = sl1 * sl2 + cl1 * cl2 * cdelta;

        double ad = Math.atan2(y, x);
        double dist = ad * EARTH_RADIUS;

        return (int)dist;


}

    /**
     * Get all cities near current city in radius.
     *
     * @param cityName - city
     * @param radius   - radius in kilometers for search
     * @throws IllegalArgumentException if city with cityName city doesn't exist.
     */
    public List<String> getCitiesNear(String cityName, int radius) {
        if (!this.citiesNames().contains(cityName)){
            throw new IllegalArgumentException("if city with cityName city doesn't exist.");}
        return cities.stream().filter(f -> ((this.getDistance(cityName, f.getName()) <= radius) && (!f.getName().equals(cityName)))).map(CityInfo::getName).toList();
    }
}
