package by.it.titkovskaya.jd03_03;

import by.it.titkovskaya.jd03_03.beans.User;

import java.lang.reflect.Field;

public class Run {
    public static void main(String[] args) throws IllegalAccessException {
        String sql = "INSERT INTO `table` (";
        String values = "";
        String delimiter = "";
        User user = new User();
        Field[] fields = User.class.getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            sql=sql.concat(delimiter + "`" + fields[i].getName() + "`");
            fields[i].setAccessible(true);
            values=values.concat(delimiter + "'" + fields[i].get(user) + "'");
            delimiter=",";
        }

        sql=sql + ") VALUES (" + values + ")";
        System.out.println(sql);
        System.out.println(values);
        System.out.println(user.getLogin());

        fields[0].setAccessible(true);

        String sql2 = "UPDATE `table` SET ";
        String delimiter2 = "";
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sql2=sql2.concat(delimiter2 + "`" + fields[i].getName() + "`='" + fields[i].get(user) + "'");
            delimiter2=",";
        }
        sql2=sql2 + " WHERE `id`='" + fields[0].get(user) + "'";
        System.out.println(sql2);

    }

}
