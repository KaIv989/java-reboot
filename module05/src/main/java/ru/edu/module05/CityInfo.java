package ru.edu.module05;

import java.util.HashMap;
import java.util.Map;

/**
 * City info
 */
public class CityInfo {

    private String name;
    private GeoPosition position;

    /**
     * Ctor.
     *
     * @param name     - city name
     * @param position - position
     */
    public CityInfo(String name, GeoPosition position) {
        this.name = name;
        this.position = position;
    }

    public Map<String,GeoPosition> getters(){
        Map<String,GeoPosition> cities = new HashMap<>();
        cities.put(this.name, this.position);
        return cities;
    }

    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return "CityInfo" + "(" + this.name + "," + this.position + ")";
    }
}