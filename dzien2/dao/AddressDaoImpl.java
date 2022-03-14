package dzien2.dao;

import dzien1.przyklad4.Address;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Override
    public List<Address> getAll() {
        List<Address> addresses = new ArrayList<>();
        String query = "SELECT * FROM address";
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                addresses.add(getAddress(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return addresses;
    }

    private Address getAddress(ResultSet resultSet) throws SQLException {
        return new Address(
                resultSet.getInt("ADD_ID"),
                resultSet.getString("ADD_STREET"),
                resultSet.getString("ADD_BUILDING_NO"),
                resultSet.getString("ADD_APARTAMENT_NO"),
                resultSet.getString("ADD_CITY"),
                resultSet.getString("ADD_POSTAL_CODE"),
                new CountryDaoImpl().findById(resultSet.getInt("ADD_CO_ID")));
    }

    @Override
    public Address findById(int id) {
        String query = "SELECT * FROM address WHERE ADD_ID = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getAddress(resultSet);
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void addNewAddress(Address address) {
        String query = "INSERT INTO address VALUES(ADD_ID, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getBuildingNo());
            preparedStatement.setString(3, address.getApartmentNo());
            preparedStatement.setString(4, address.getCity());
            preparedStatement.setString(5, address.getPostalCode());
            preparedStatement.setInt(6, address.getCountry().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean deleteAddress(int id) {
        String query = "DELETE FROM address WHERE ADD_ID = ?";
        if (findById(id) != null) {
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return false;
            }
        }

        return false;
    }

    @Override
    public void updateAddress(Address address) {
        String query = "UPDATE address " +
                "SET ADD_STREET = ?, ADD_BUILDING_NO = ?, ADD_APARTAMENT_NO = ?, " +
                "ADD_CITY = ?, ADD_POSTAL_CODE = ?, ADD_CO_ID = ? " +
                "WHERE ADD_ID = ?";

        if (address.getId() != null && findById(address.getId()) != null) {

            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, address.getStreet());
                preparedStatement.setString(2, address.getBuildingNo());
                preparedStatement.setString(3, address.getApartmentNo());
                preparedStatement.setString(4, address.getCity());
                preparedStatement.setString(5, address.getPostalCode());
                preparedStatement.setInt(6, address.getCountry().getId());
                preparedStatement.setInt(7, address.getId());

                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


    private Connection getConnection() {
        return new DatabaseConnection().getConnection();
    }
}
