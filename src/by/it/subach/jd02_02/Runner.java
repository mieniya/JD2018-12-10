package by.it.subach.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Runner {
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
//        Util.fillPriceList(Util.priceList);
//        System.out.println("Раскладываем товар по полкам");
//        System.out.println(Util.priceList.toString());
        System.out.println("Market is opened");

        System.out.println("Market opened");
        int number = 0;

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            threads.add(cashier);
            Dispatcher.waitingCashiers.add(cashier);
            cashier.start();
        }

        while (Dispatcher.marketOpen()) {

            int count = Util.getRandom(3);
            for (int i = 0; i < count; i++) {
                if (Dispatcher.marketOpen()) {
                    Buyer buyer = new Buyer(++number);
                    threads.add(buyer);
                    buyer.start();
                }
            }
            int queueSize = DequeBuyer.getQueueSize();
                Cashier.cashiersManager(queueSize);
//            проверяем размер очереди и вызываем менеджера по кассирам

            Util.sleep(1000 / Dispatcher.K_SPEED);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");

    }

}
