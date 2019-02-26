package by.it.lyakhova.jd03_02.crud;

import by.it.lyakhova.jd03_02.bean.Transport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransportCRUD {

    public Transport read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT*FROM transport WHERE id = '%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Transport transport = new Transport();
                transport.setId(resultSet.getLong("id"));


                return transport;
            }
        }
        return null;
    }

}
