package by.it.naron.jd03_04.java.controller;

import by.it.naron.jd03_04.java.beans.Goods_flower;
import by.it.naron.jd03_04.java.beans.Orders;
import by.it.naron.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CmdCreateOrders implements Cmd {



//    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        Timestamp timestamp = Timestamp.valueOf(now);
//        System.out.println(timestamp);
//    }

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            Orders orders = new Orders();
            orders.setAmount(Form.getInt(req,"amount"));
            orders.setTime_delivery(Form.getInt(req,"time_delivery"));
            orders.setTotal_price(Form.getDouble(req,"total_price"));
            Timestamp date = Timestamp.valueOf(LocalDateTime.now());
            orders.setDate_orders(date);
            //todo userid
            orders.setUsers_id(2);
            orders.setGoods_flower_id(2);
            if (Dao.getDao().orders.create(orders))
                return Action.INDEX;
        }
        return Action.CREATEORDERS;
    }
}
