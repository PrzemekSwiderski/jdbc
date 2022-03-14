package dzien2.dao;

import dzien1.przyklad4.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getAll();

    Country findById(int id);

    void addNewCountry(Country country);

    boolean deleteCountry(int id);

    void updateCountry(Country country);
}
