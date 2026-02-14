package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }





    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        // Same values as mockCity()
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
        // Check for values not in mockCityList
        assertFalse(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        // Delete city in list
        cityList.deleteCity(new City("Edmonton", "Alberta"));
        // Check deletion
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testDeleteCityException() {
        CityList cityList = mockCityList();
        // Deleting city not in list
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(new City("Regina", "Saskatchewan"));
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        // Adding city to list and counting
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
    }

}
