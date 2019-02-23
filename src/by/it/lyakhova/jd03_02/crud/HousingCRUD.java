package by.it.lyakhova.jd03_02.crud;

import by.it.lyakhova.jd03_02.bean.Housing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HousingCRUD {
    public Housing read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT*FROM housing WHERE id = '%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Housing housing = new Housing();
                housing.setId(resultSet.getLong("id"));


                return housing;
            }
        }
        return null;
    }
}
