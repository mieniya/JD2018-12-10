package by.it.subach.jd03_02.beans;

public class Checkout {

    private int id;
    private boolean checkoutStatus;
    private int order_id;

    public Checkout() {
    }

    public Checkout(int id, boolean checkoutStatus, int order_id) {
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

    public boolean isCheckoutStatus() {
        return checkoutStatus;
    }

    public void setCheckoutStatus(boolean checkoutStatus) {
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
