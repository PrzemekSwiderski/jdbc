package dzien2.dao;

import dzien1.przyklad4.Address;

public class Main {
    public static void main(String[] args) {

        CountryDao countryDao = new CountryDaoImpl();
/*
       // System.out.println(countryDao.findById(1));
        //countryDao.addNewCountry(countryDao.findById(1));
        countryDao.getAll().forEach(System.out::println);
        countryDao.updateCountry(new Country(9, "WielkaPolsza", "PL2"));
       //System.out.println(countryDao.deleteCountry(8));
        System.out.println("================");
        countryDao.getAll().forEach(System.out::println);
*/

        AddressDao addressDao = new AddressDaoImpl();
       // addressDao.getAll().forEach(System.out::println);
       // System.out.println(addressDao.findById(1));

//        addressDao.addNewAddress(new Address("Dolna", "69a", "5", "Radom", "69-420", countryDao.findById(1)));
//        System.out.println(addressDao.deleteAddress(8));
//        System.out.println(addressDao.deleteAddress(8));
//        System.out.println(addressDao.deleteAddress(9));

        addressDao.updateAddress(new Address(9,"Gorna", "13", "5", "Radomsko", "69-420", countryDao.findById(1)));

    }
}
