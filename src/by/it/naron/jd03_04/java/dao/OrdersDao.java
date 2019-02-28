package by.it.naron.jd03_04.java.dao;

import by.it.naron.jd03_04.java.beans.Orders;

public class OrdersDao extends UniversalDao<Orders> {
    public OrdersDao() {
        super(Orders.class, "orders");
    }
}
