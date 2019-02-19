package by.it.subach.jd03_02;

import by.it.subach.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    boolean create(User user) throws SQLException {
        try(
        Connection connection = ConnCreator.getConnection();
        Statement statement = connection.createStatement();
        ){
            String sql = String.format("INSERT INTO `users`(`login`, `email`, `password`, `roles_id`) " +
                    "VALUES ('%s','%s','%s','%s')", user.getLogin(), user.getEmail(), user.getPassword(), user.getRole_id());

            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if(count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    User read (long id) throws SQLException{
        try(
                Connection connection = ConnCreator.getConnection();
                Statement statement = connection.createStatement();
        ){
            String sql = String.format("SELECT * FROM `users` 'id=' '%d'", id);
            ResultSet resultSet = statement.executeQuery(sql);
            User user = new User();
            if(resultSet.next()){
                //TODO
            }
//                user.setId(resultSet.getLong("id"));
            }

    }
}
