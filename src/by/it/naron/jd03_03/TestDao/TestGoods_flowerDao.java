package by.it.naron.jd03_03.TestDao;

import by.it.naron.jd03_03.beans.Goods_flower;
import by.it.naron.jd03_03.dao.Dao;

import java.sql.SQLException;

public class TestGoods_flowerDao {


    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();
        Goods_flower goodsFlower = new Goods_flower(2,"sname","scolour",3,3.6);
        goodsFlower.setId(3);
        if (dao.goodsFlower.create(goodsFlower))
            System.out.println("CREATE OK: " + goodsFlower);
        goodsFlower.setColour("TestAd");
        if (dao.goodsFlower.update(goodsFlower))
            System.out.println("UPDATE OK: " + goodsFlower);
        goodsFlower = dao.goodsFlower.read(goodsFlower.getId());
        if (goodsFlower != null)
            System.out.println("READ OK: " + goodsFlower);
        if (dao.goodsFlower.delete(goodsFlower))
            System.out.println("DELETE OK: " + goodsFlower);

    }
}

