package by.it.yarmolenka.jd02_03;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private String name;
    Basket basket = new Basket();
    boolean retired;

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        Goods goods = new Goods();
        int priceListSize = goods.getPriceListSize();
        for (int i = 0; i < Utils.getRandom(1, 4); i++) {
            chooseGoods();
            putGoodsToBasket(goods, priceListSize);
        }
        goToQueue();
        goOut();
    }

    private void goToQueue() {
        Dispatcher.semaphoreBuyers.release();
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " went to queue");
        }
        BuyerQueue.putToQueue(this);
        try {
            Dispatcher.semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Buyer(int number) {
        Dispatcher.buyersCount.incrementAndGet();
        this.retired = Math.random() < 0.25;
        if (this.retired) this.name = "Buyer #" + number + "(retired)";
        else this.name = "Buyer #" + number;
    }

    @Override
    public void enterToMarket() {
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " entered the market");
        }
    }

    @Override
    public void chooseGoods() {
        int time = Utils.getRandom(500, 2000);
        Utils.sleep(this.retired ? (int) (time * 1.5) : time);
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " is choosing goods");
        }
    }

    @Override
    public void goOut() {
        Dispatcher.semaphoreBaskets.release();
        Dispatcher.buyersCount.decrementAndGet();
        Dispatcher.buyersComplete.incrementAndGet();
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " exited the market");
        }
    }

    @Override
    public void takeBasket() {
        try {
            Dispatcher.semaphoreBaskets.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " took basket");
        }
        int time = Utils.getRandom(100, 200);
        Utils.sleep(this.retired ? (int) (time * 1.5) : time);
        try {
            Dispatcher.semaphoreBuyers.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBasket(Goods listOfGoods, int listSize) {
        String goods = Utils.getRandomGoods(listSize);
        synchronized (Dispatcher.LOCK_CONSOLE) {
            System.out.println(this + " took " + goods);
        }
        int time = Utils.getRandom(100, 200);
        Utils.sleep(this.retired ? (int) (time * 1.5) : time);
        int price = listOfGoods.getPrice(goods);
        this.basket.goods.put(goods, price);
    }
}
