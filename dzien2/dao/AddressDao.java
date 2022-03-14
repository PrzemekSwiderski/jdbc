package dzien2.dao;

import dzien1.przyklad4.Address;
import dzien1.przyklad4.Country;

import java.util.List;

public interface AddressDao {
    List<Address> getAll();

    Address findById(int id);

    void addNewAddress(Address address);

    boolean deleteAddress(int id);

    void updateAddress(Address address);
}
