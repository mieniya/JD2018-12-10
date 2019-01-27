package by.it.kushnerov.jd02_01;

public class Buyer extends Thread implements IBuyer {

    public Buyer(int number) {
        super("Buyer №"+number);
    }

    @Override
    public void run(){
        enterToMarket();
        chooseGoods();
        goOut();
        System.out.flush();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter the Market");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this+"chose goods"+timeout+"mileseconds");
        Util.sleep(timeout);
        System.out.println(this+" chose goods");
    }

    @Override
    public void goOut() {
        System.out.println("go out of the market");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
