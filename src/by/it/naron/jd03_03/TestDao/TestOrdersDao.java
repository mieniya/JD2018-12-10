package by.it.naron.jd03_03.TestDao;

import by.it.naron.jd03_03.beans.Orders;
import by.it.naron.jd03_03.beans.Users;
import by.it.naron.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.sql.Timestamp;

public class TestOrdersDao {

    public static void main(String[] args) throws SQLException {
        Timestamp date = new Timestamp(1550582031901L);

        Dao dao=Dao.getDao();
        Orders orders = new Orders(1,2,3,date,2.3,2,2);
        orders.setId(3);
        if (dao.orders.create(orders))
            System.out.println("CREATEGOODSFLOWER OK: " + orders);
        orders.setAmount(5);
        if (dao.orders.update(orders))
            System.out.println("UPDATE OK: " + orders);
        orders = dao.orders.read(orders.getId());
        if (orders != null)
            System.out.println("READ OK: " + orders);
        if (dao.orders.delete(orders))
            System.out.println("DELETE OK: " + orders);

    }
}
