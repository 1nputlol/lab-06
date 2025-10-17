package com.example.listycity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CityListTest {
    public City mockCity(){
        return new City("Edmonton", "AB");
    }
    public CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City c = new City("Regina", "SK");
        cityList.add(c);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(c));
    }
    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City c = new City("Charlottetown", "PEI");
        cityList.add(c);
        assertEquals(0, c.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    public void testHasCity() {
        CityList cityList = new CityList();
        City city = new City("Edmonton", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }
    @Test
    public void testDeleteCity() {
        CityList list = new CityList();
        City city = new City("Calgary", "Alberta");
        list.add(city);
        list.delete(city);
        assertFalse(list.hasCity(city));
    }
    @Test
    public void testDeleteException() {
        CityList list = new CityList();
        City city = new City("Vancouver", "BC");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
    }
    @Test
    public void testCountCities() {
        CityList list = new CityList();
        list.add(new City("Toronto", "Ontario"));
        list.add(new City("Halifax", "Nova Scotia"));
        assertEquals(2, list.countCities());
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
}
