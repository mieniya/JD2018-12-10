package by.it.yarmolenka.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private Basket basket = new Basket();
    private boolean retired = false;

    Buyer(int number) {
        super("buyer №" + number);
    }

    Buyer(int number, boolean retired) {
        super("buyer №" + number);
        this.retired = retired;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " entered the market");
        Dispatcher.buyersCount++;
    }

    @Override
    public void chooseGoods() {
        int timeout = Utils.getRandom(500, 2000);
        System.out.println(this.getName() + " is choosing goods " + timeout + " milliseconds");
        Utils.sleep(retired ? (int) (timeout * 1.5) :timeout);
    }

    @Override
    public void goOut() {
        System.out.println(this.getName() + " exited the market");
        Dispatcher.buyersCount--;
    }

    @Override
    public void takeBasket() {
        System.out.println(this.getName() + " took basket");
        int timeToTakeBasket = Utils.getRandom(100, 200);
        Utils.sleep(retired ? (int) (timeToTakeBasket * 1.5) : timeToTakeBasket);
    }

    @Override
    public void putGoodsToBasket() {
        int quantity = Utils.getRandom(1, 4);
        for (int i = 0; i < quantity; i++) {
            String good = Utils.getRandomGood();
            System.out.println(this.getName() + " взял " + good);
            int timeToTakeGood = Utils.getRandom(100,200);
            Utils.sleep(retired? (int) (timeToTakeGood * 1.5) :timeToTakeGood);
            double price = Goods.goods.get(good);
            this.basket.goods.put(good, price);
        }
    }
}
