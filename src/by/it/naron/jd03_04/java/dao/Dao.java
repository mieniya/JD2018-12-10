package by.it.naron.jd03_04.java.dao;

import java.sql.SQLException;

public class Dao {

//    private static Dao instance;
private volatile static Dao dao;


    public RolesDao roles;
    public UsersDao users;
    public OrdersDao orders;
    public Goods_flowerDao goodsFlower;

    public void reset() throws SQLException {
        Reset.main(new String[0]);
    }

    private Dao() {
        roles=new RolesDao();
        users=new UsersDao();
        orders=new OrdersDao();
        goodsFlower = new Goods_flowerDao();

    }
    public static Dao getDao(){
        if (dao==null) {
            synchronized (Dao.class){
                if (dao==null)
                    dao=new Dao();
            }
        }
        return dao;
    }
}
