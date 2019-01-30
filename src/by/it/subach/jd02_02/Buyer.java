package by.it.subach.jd02_02;

public class Buyer extends Thread implements IByuer, IUseBasket {

    Buyer getMonitor() {
        return this;
    }

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.newBuyer();
    }

    // my fields
    private double speed = 1;       //коэфициент скорости (если пенсионер, то умножаем на 1.5
    static int pens;                //кол-во пенсионеров
    private boolean pensioneer;     //пенсионер ли?

    @Override
    public void run() {
        checkAge();
        if (pensioneer) speed = 1.5;
        enterToMarket();
        takeBasket();
        int goodsCount = Util.getRandom(1, 4);
        for (int i = 1; i <= goodsCount; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        goToQueue();
        goOut();
        System.out.flush();
        Dispatcher.buyerComplete();
//        Dispatcher.counterBuyer--;
    }

    @Override
    public void enterToMarket() {
//        System.out.println(this + " enter to Market");
//        System.out.flush();
    }

    @Override
    public void chooseGoods() {
        int timeout = (int) (Util.getRandom(500, 2000) * speed);
        int value = Util.getRandom(Util.products.length - 1);
        String good = Util.products[value];
//        System.out.println(this + " choose " + good + ". Cost: " + Util.priceList.get(good) + " in " + timeout + " msec");
        Util.sleep(timeout);
    }

    @Override
    public void goToQueue() {
//        System.out.println(this + " go to queue");
        DequeBuyer.add(this);
        synchronized (this){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
//        System.out.println(this + " go out from market\n");
//        System.out.flush();
//        Dispatcher.counterBuyer--;
//        Util.sleep(200);
    }

    @Override
    public void takeBasket() {
        int timeout = (int) (Util.getRandom(100, 200) * speed);
//        System.out.println(this + " take the basket in " + timeout + " msec");
        Util.sleep(timeout);
    }

    @Override
    public void putGoodsToBasket() {
        int timeout = (int) (Util.getRandom(100, 200) * speed);
//        System.out.println(this + " put good to basket " + timeout + " msec");
        Util.sleep(timeout);

    }

    private void checkAge() {
        if (Math.random() < 0.25) {
            pensioneer = true;
            pens++;
        }
    }

    @Override
    public String toString() {
        if (pensioneer) return this.getName() + " пенсионер";
        else return this.getName();
    }


}
