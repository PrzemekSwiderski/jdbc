package dzien2.dao;


import dzien1.przyklad4.Country;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDao {

    private static final int CO_ID_PARAMETER_INDEX = 1;
    private static final int CO_NAME_PARAMETER_INDEX = 1;
    private static final int CO_ALIAS_PARAMETER_INDEX = 2;


    @Override
    public List<Country> getAll() {
        List<Country> countries = new ArrayList<>();

        String sqlSelect = "SELECT * FROM country";

        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                countries.add(mapResultSetToCountry(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return countries;
    }

    @Override
    public Country findById(int id) {
        String sqlSelect = "SELECT * FROM country WHERE CO_ID = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sqlSelect)) {
            preparedStatement.setInt(CO_ID_PARAMETER_INDEX, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToCountry(resultSet);
            } else {
                return null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;

    }

    @Override
    public void addNewCountry(Country country) {
        String insert = "INSERT INTO country VALUES(CO_ID, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(insert)) {
            preparedStatement.setString(CO_NAME_PARAMETER_INDEX, country.getName());
            preparedStatement.setString(CO_ALIAS_PARAMETER_INDEX, country.getAlias());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public boolean deleteCountry(int id) {
        String sqlDelete = "DELETE FROM country WHERE CO_ID = ?";
        if (findById(id) != null) {
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(sqlDelete)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public void updateCountry(Country country) {
        String sqlUpdate = "UPDATE country SET CO_NAME = ?, CO_ALIAS = ? WHERE CO_ID = ?";
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sqlUpdate)) {
            preparedStatement.setInt(3, country.getId());
            preparedStatement.setString(1, country.getName());
            preparedStatement.setString(2, country.getAlias());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private Country mapResultSetToCountry(ResultSet resultSet) throws SQLException {
        return new Country(resultSet.getInt("CO_ID"), resultSet.getString("CO_NAME"), resultSet.getString("CO_ALIAS"));
    }

    private Connection getConnection() {
        return new DatabaseConnection().getConnection();
    }

}
