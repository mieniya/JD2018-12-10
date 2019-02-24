package by.it.migunko.jd03_03.dao;
import by.it.migunko.jd03_02.connection.ConnCreator;
import by.it.migunko.jd03_03.beans.Tours;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TourDao extends AbstractDao implements InterfaceDao<Tours>{
    @Override
    public boolean create(Tours tours) throws SQLException {
        String sql = String.format("INSERT INTO " +
                        "`tours`(`description`, `typeOfTravel`, `destination`, " +
                        "`hotel`,  `countOfNights`, `price`, `users_id`) " +
                        "VALUES ('%s','%s','%s','%s',%d,%f,%d)",
                tours.getDescription(), tours.getTypeOfTravel(), tours.getDestination(),
                tours.getHotel(),  tours.getCountOfNights(),
                tours.getPrice(), tours.getUsers_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            tours.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public Tours read(long id) throws SQLException {
        List<Tours> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean update(Tours tours) throws SQLException {
        String sql = String.format(
                "UPDATE `tours` " +
                        "SET `description`='%s', `typeOfTravel`='%s',`destination`='%s'," +
                        "`hotel`='%s', `countOfNights`=%d, " +
                        "`price`=%f, `users_id`=%d WHERE id=%d",
                tours.getDescription(), tours.getTypeOfTravel(), tours.getDestination(),
                tours.getHotel(),  tours.getCountOfNights(),
                tours.getPrice(), tours.getUsers_id(), tours.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Tours tours) throws SQLException {
        String sql = String.format(
                "DELETE FROM `tours` WHERE id=%d",
                tours.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Tours> getAll(String where) throws SQLException {
        List<Tours> tours = new ArrayList<>();
        try (
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(
                            "SELECT * FROM `tours` "+ where);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Tours tour = new Tours(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getString("typeOfTravel"),
                        resultSet.getString("destination"),
                        resultSet.getString("hotel"),
                        resultSet.getInt("countOfNights"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("users_id")
                );
                tours.add(tour);
            }
        }
        return tours;
    }
}
