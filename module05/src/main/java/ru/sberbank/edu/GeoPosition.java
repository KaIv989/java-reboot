package ru.sberbank.edu;

import java.util.List;

/**
 * Geo position.
 */
public class GeoPosition {

    /**
     * Широта в радианах.
     */
    private double latitude;

    /**
     * Долгота в радианах.
     */
    private double longitude;

    /**
     * Ctor.
     *
     * @param latitudeGradus  - latitude in gradus
     * @param longitudeGradus - longitude in gradus
     *                        Possible values: 55, 55(45'07''), 59(57'00'')
     */
    public GeoPosition(String latitudeGradus, String longitudeGradus) {

        String[] splitGradus = latitudeGradus.split("[\\'\\(]");
        this.latitude = Double.parseDouble(splitGradus[0]) + (Double.parseDouble(splitGradus[1]) + Double.parseDouble(splitGradus[2])/60)/60;
        splitGradus = longitudeGradus.split("[\\'\\(]");
        this.longitude = Double.parseDouble(splitGradus[0]) + (Double.parseDouble(splitGradus[1]) + Double.parseDouble(splitGradus[2])/60)/60;
    }

    public double[] getters(){
        double[] coordinates = {this.latitude, this.longitude};
        return  coordinates;
    };
    @Override
    public String toString(){
        return "Координаты в радианах: Широта " + this.latitude + ", Долгота "+ this.longitude;
    }

    // getters and toString
}