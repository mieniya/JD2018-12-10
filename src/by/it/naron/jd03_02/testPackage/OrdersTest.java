package by.it.naron.jd03_02.testPackage;

import by.it.naron.jd03_02.beans.Orders;
import by.it.naron.jd03_02.crudOperations.OrdersCrud;

import java.sql.SQLException;
import java.sql.Timestamp;

public class OrdersTest {


    public static void main(String[] args) throws SQLException {


//        Orders orders = new Orders(1,5.2,2002,
//                2.0,2,2);
//      //  Roles roles = new Roles(1, "admin");
//        try {
////проверка BeanCRUD для пользователей
//      //      RolesCrud rolesCrud = new RolesCrud();
//            OrdersCrud ordersCrud = new OrdersCrud();
//
//
//            //чтение
//      //      System.out.print("read: " + rolesCrud.read(roles.getId()));
//            System.out.println("read: "+ ordersCrud.read(orders.getId()));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Timestamp date = new Timestamp(1550582031901L);

        OrdersCrud ordersCrud = new OrdersCrud();
        Orders orders = new Orders
                (0,2,500,date,2,2,2);
       if (ordersCrud.create(orders))
            System.out.println("CREATE OK: " + orders);
        orders.setAmount(9000000);
        if (ordersCrud.update(orders))
            System.out.println("UPDATE OK: " + orders);
        orders = ordersCrud.read(orders.getId());
        if (orders != null)
            System.out.println("READ OK: " + orders);
        if (ordersCrud.delete(orders))
            System.out.println("DELETE OK: " + orders);








    }


}
