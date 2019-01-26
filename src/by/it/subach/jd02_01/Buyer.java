package by.it.subach.jd02_01;

public class Buyer extends Thread implements IByuer {

    public Buyer(int number){
        super("Buyer #№" + number);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this + " chose goods" + timeout + " milliseconds");
        Util.sleep(timeout);
        System.out.println(this + " chose goods");

    }

    @Override
    public void goOut() {

    }

    @Override
    public String toString() {
        return this.getName();
    }


}
