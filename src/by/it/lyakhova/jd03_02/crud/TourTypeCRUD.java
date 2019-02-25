package by.it.lyakhova.jd03_02.crud;

import by.it.lyakhova.jd03_02.bean.TourType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TourTypeCRUD {


    public TourType read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT*FROM tour_type WHERE id = '%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                TourType tourType = new TourType();
                tourType.setId(resultSet.getLong("id"));


                return tourType;
            }
        }
        return null;
    }


}
