package by.it.naron.jd03_03.beans;

import java.sql.Timestamp;
import java.util.Objects;

public class Orders {
    private int id;
    private int  amount;
  //  private Timestamp order_date;
    private int time_delivery;
    private double price;
    private int users_id;
    private int goods_flower_id;

    public Orders() {
    }

    public Orders(int id, int amount, int time_delivery, double price, int users_id, int goods_flower_id) {
        this.id = id;
        this.amount = amount;
        this.time_delivery = time_delivery;
        this.price = price;
        this.users_id = users_id;
        this.goods_flower_id = goods_flower_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTime_delivery() {
        return time_delivery;
    }

    public void setTime_delivery(int time_delivery) {
        this.time_delivery = time_delivery;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getGoods_flower_id() {
        return goods_flower_id;
    }

    public void setGoods_flower_id(int goods_flower_id) {
        this.goods_flower_id = goods_flower_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                amount == orders.amount &&
                time_delivery == orders.time_delivery &&
                Double.compare(orders.price, price) == 0 &&
                users_id == orders.users_id &&
                goods_flower_id == orders.goods_flower_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount, time_delivery, price, users_id, goods_flower_id);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", amount=" + amount +
                ", time_delivery=" + time_delivery +
                ", price=" + price +
                ", users_id=" + users_id +
                ", goods_flower_id=" + goods_flower_id +
                '}';
    }
}
