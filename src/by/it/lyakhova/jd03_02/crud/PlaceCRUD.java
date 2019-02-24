package by.it.lyakhova.jd03_02.crud;

import by.it.lyakhova.jd03_02.bean.Place;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlaceCRUD {


    public Place read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT*FROM place WHERE id = '%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Place place = new Place();
                place.setId(resultSet.getLong("id"));
                place.setCountry(resultSet.getString("country"));
                place.setTown(resultSet.getString("town"));
                return place;
            }
        }
        return null;
    }


}
