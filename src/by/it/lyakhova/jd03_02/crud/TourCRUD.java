package by.it.lyakhova.jd03_02.crud;
import by.it.lyakhova.jd03_02.bean.Tour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TourCRUD {

    public boolean create(Tour tour) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO tours(name, tour_type_id, place_id, transport_id," +
                    "housing_id, price, date, duration, hot, discount) " +
                    "VALUES ('%s', '%d', '%d', '%d', '%d', '%d', '%s', '%d', '%d', '%d')", tour.getName(),
                    tour.getTour_type_id(), tour.getPlace_id(), tour.getTransport_id(), tour.getHousing_id(),
                    tour.getPrice(), tour.getDate(), tour.getDuration(), tour.getHot(), tour.getDiscount());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    tour.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Tour read(long id) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT*FROM tours WHERE id = '%d'", id);

            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getLong("id"));
                tour.setName(resultSet.getString("name"));
                tour.setTour_type_id(resultSet.getLong("tour_type_id"));
                tour.setPlace_id(resultSet.getLong("place_id"));
                tour.setTransport_id(resultSet.getLong("transport_id"));
                tour.setHousing_id(resultSet.getLong("housing_id"));
                tour.setPrice(resultSet.getInt("price"));
                tour.setDate(resultSet.getString("date"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setHot(resultSet.getInt("hot"));
                tour.setDiscount(resultSet.getInt("discount"));

                return tour;
            }
        }
        return null;
    }

    public boolean update(Tour tour) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE tours SET name = '%s', tour_type_id = '%d', place_id = '%d', transport_id = '%d'," +
                            " housing_id = '%d', price = '%d', date = '%s', duration = '%d', hot = '%d'," +
                            " discount = '%d'  WHERE id = '%d'",
                    tour.getName(), tour.getTour_type_id(), tour.getPlace_id(), tour.getTransport_id(),
                    tour.getHousing_id(), tour.getPrice(), tour.getDate(), tour.getDuration(), tour.getHot(),
                    tour.getDiscount(), tour.getId());

            return 1 == statement.executeUpdate(sql);
        }
    }

    public boolean delete(Tour tour) throws SQLException {
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM tours WHERE id = '%d'", tour.getId());

            return 1 == statement.executeUpdate(sql);
        }
    }
}
