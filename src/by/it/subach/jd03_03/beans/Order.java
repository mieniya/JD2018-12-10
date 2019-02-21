package by.it.subach.jd03_03.beans;

public class Order {

    private int id;
    private long user_id;
    private int product_id;

    public Order() {
    }

    public Order(int id, int user_id, int product_id) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public long getUser_id() {
        return user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                '}';
    }
}
