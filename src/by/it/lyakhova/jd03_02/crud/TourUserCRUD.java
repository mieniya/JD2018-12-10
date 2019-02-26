package by.it.lyakhova.jd03_02.crud;

import by.it.lyakhova.jd03_02.bean.TourUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TourUserCRUD {

    public boolean create(TourUser tourUser) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO tours_has_users (tours_id, users_id) " +
                    "VALUES ('%d', '%d')", tourUser.getTours_id(), tourUser.getUsers_id());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    tourUser.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public TourUser read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT*FROM tours_has_users WHERE id = '%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                TourUser tourUser = new TourUser();
                tourUser.setId(resultSet.getLong("id"));


                return tourUser;
            }
        }
        return null;
    }

    public boolean update(TourUser tourUser) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE tours_has_users SET tours_id = '%d', users_id = '%d'",
                    tourUser.getTours_id(), tourUser.getUsers_id());

            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(TourUser tourUser) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM tours_has_users WHERE id = '%d'", tourUser.getId());

            return 1 == statement.executeUpdate(sql);
        }
    }
}
