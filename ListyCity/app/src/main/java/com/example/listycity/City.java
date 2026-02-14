package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */

public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * Creates a new City object with a city name and a province name
     * @param city the city name
     * @param province the province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets the province name
     * @return the province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this City with another City name
     * This allows City objects to be sorted
     * @param o the other City to compare to
     * @return a negative number if this city name comes before the other,
     * 0 if they are equal,
     * a positive number if this city name comes after the other
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }



    /**
     * Checks if this City is equal to another City name and province
     * @param o the object to compare with
     * @return true if the objects represent the same city and province, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return Objects.equals(city, other.city) && Objects.equals(province, other.province);
    }

    /**
     * Returns a hash code for this City so that City objects can be used
     * correctly in hash-based collections .
     * @return the hash code value for this City
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
