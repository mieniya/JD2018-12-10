package by.it.subach.jd03_03.beans;

public class Checkout {

    private int id;
    private int checkoutStatus;
    private int order_id;

    public Checkout() {
    }

    public Checkout(int id, int checkoutStatus, int order_id) {
        this.id = id;
        this.checkoutStatus = checkoutStatus;
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheckoutStatus() {
        return checkoutStatus;
    }

    public void setCheckoutStatus(int checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "id=" + id +
                ", checkoutStatus=" + checkoutStatus +
                ", order_id=" + order_id +
                '}';
    }
}
