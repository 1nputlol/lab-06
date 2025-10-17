package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds the City type objects in a list
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This method adds a city object to the cities list
     * @param city
     *      This is a City object we want to add to the List
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city){
        if(cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This method sorts the list of cities
     * @return a sorted list
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * Checks if a city exists in the list
     * @param city the city to look for
     * @return true if city exists, false otherwise
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }
    /**
     * Removes a city if it exists, otherwise throws exception
     * @param city the city to remove
     * @throws IllegalArgumentException if city not found
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found");
        }
        cities.remove(city);
    }
    /**
     * Gets the number of cities in the list
     * @return number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
