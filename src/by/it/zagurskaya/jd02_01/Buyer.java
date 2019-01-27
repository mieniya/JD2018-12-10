package by.it.zagurskaya.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private Backet backet = new Backet();

    Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
        System.out.flush();
        Dispatcher.counterBuyer--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to Market");
    }

    @Override
    public void chooseGoods() {
        takeBucket();
        int timeout = Util.getRandom(500, 2000);
        System.out.println(this + " chose goods " + timeout + " milliseconds");

        while (timeout > 0) {
            Integer pickDelayTime = Util.getRandom(100, 200);
            Util.sleep(pickDelayTime);
            putGoodsToBucket();
            timeout = timeout - pickDelayTime;
        }
        System.out.println(this + " chose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "go out from Market");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBucket() {
        System.out.println(this + "took the basket");
    }

    @Override
    public void putGoodsToBucket() {
        if (backet.show().size() < 4) {
            Map<String, Double> pickGood = Showcase.getGoodByOrder();
            backet.put(pickGood);
            System.out.println(this + " chose good " + pickGood.toString());
        }
    }
}
