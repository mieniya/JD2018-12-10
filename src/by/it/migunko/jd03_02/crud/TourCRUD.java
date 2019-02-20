package by.it.migunko.jd03_02.crud;
import by.it.migunko.jd03_02.beans.Tours;
import by.it.migunko.jd03_02.connection.ConnCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TourCRUD {
    public boolean create(Tours tours) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO " +
                            "`tours`(`description`, `typeOfTravel`, `destination`, " +
                            "`hotel`,  `countOfNights`, `price`, `users_id`) " +
                            "VALUES ('%s','%s','%s','%s',%d,%f,%d)",
                    tours.getDescription(), tours.getTypeOfTravel(), tours.getDestination(),
                    tours.getHotel(), tours.getCountOfNights(),
                    tours.getPrice(), tours.getUsers_id());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    tours.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Tours read(long id) throws SQLException {
        Tours tours = null;
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                            "SELECT `id`, `description`, `typeOfTravel`, `destination`, " +
                            "`hotel`,  `countOfNights`, " +
                            "`price`, `users_id` FROM `tours` WHERE id=%d",
                    id);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                tours = new Tours(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getString("typeOfTravel"),
                        resultSet.getString("destination"),
                        resultSet.getString("hotel"),
                        resultSet.getInt("countOfNights"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("users_id")
                );
            }
        }
        return tours;
    }

    public boolean update(Tours tours) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `tours` " +
                            "SET `description`='%s', `typeOfTravel`='%s',`destination`='%s'," +
                            "`hotel`='%s',  `countOfNights`=%d, " +
                            "`price`=%f, `users_id`=%d WHERE id=%d",
                    tours.getDescription(), tours.getTypeOfTravel(), tours.getDestination(),
                    tours.getHotel(),  tours.getCountOfNights(),
                    tours.getPrice(), tours.getUsers_id());
            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Tours tours) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM `tours` WHERE id=%d",
                    tours.getId());
            return 1 == statement.executeUpdate(sql);
        }
    }
}
