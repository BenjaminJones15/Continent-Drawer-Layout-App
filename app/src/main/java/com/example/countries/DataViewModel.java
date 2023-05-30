package com.example.countries;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * this is a simple viewmodel class holding two data items.
 */

public class DataViewModel extends ViewModel {
    CountryData countrydata = new CountryData();
    ArrayList<String> Continents = countrydata.Continents;
    List<String> countries;

    public void setListsoflist(ArrayList<String> countries) {
        this.countries = countries;
    }

    public ArrayList<String> getContinents() {
        return Continents;
    }

    public List<String> getCountries(String mycontinent) {              //gets countries in continent with string
        int continentnum = countrydata.name2num(mycontinent);
        countries = countrydata.getlist(continentnum);
        return countries;
    }

    public List<String> getCountries(int mycontinent){      //gets countries in a continent with int
        countries = countrydata.getlist(mycontinent);
        return countries;
    }

    public void add(String name, String mycontinent){       //gets data and adds it to country data
        int continentnum = countrydata.name2num(mycontinent);
        countrydata.add(name, continentnum);
    }

}
