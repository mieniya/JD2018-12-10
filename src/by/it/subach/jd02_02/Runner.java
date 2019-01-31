package by.it.subach.jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Runner {
    private static List<Thread> threads = new ArrayList<>();
    static List<Cashier> cashiers = new ArrayList<>();
    static int number = 0;
    static volatile int cashiersOnDuty =0;


    public static void main(String[] args) {
//        Util.fillPriceList(Util.priceList);
//        System.out.println("Раскладываем товар по полкам");
//        System.out.println(Util.priceList.toString());
        System.out.println("Market is opened");

        System.out.println("Market opened");
        int number = 0;

        Object sync = new Object();
        for (int i = 1; i <= 3; i++) {
            Cashier cashier = new Cashier(i);
            threads.add(cashier);
            cashiers.add(cashier);
            cashier.start();
        }

        while (Dispatcher.marketOpen()) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++) {
                if (Dispatcher.marketOpen()) {
                    Buyer buyer = new Buyer(++number);
                    threads.add(buyer);
                    buyer.start();
                }
            }
            int sizeQueue = DequeBuyer.getBuyerSize();
            System.out.println(sizeQueue);
            if (sizeQueue == 1) {
                goToWork();
                System.out.println("Cashiers on duty " + cashiersOnDuty);
                Util.sleep(1000);
            }
            if (sizeQueue == 6) {
                goToWork();
                System.out.println("Cashiers on duty " + cashiersOnDuty);
                Util.sleep(1000);
            }
            if (sizeQueue == 11) {
                goToWork();
                System.out.println("Cashiers on duty " + cashiersOnDuty);
                Util.sleep(1000);
            }

//            if ((sizeQueue) / 5 < cashiersOnDuty + 1 && sizeQueue > 0){
//                System.out.println("BOOM");
//                goToSleep();
//                cashiersOnDuty--;
//                System.out.println("go to sleep");
//            }



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
    private static void goToWork(){
        synchronized (Cashier.MONITOR){
            Cashier.MONITOR.notify();
            cashiersOnDuty++;
            Util.sleep(1000);
        }
    }

    private static void goToSleep(){
        synchronized (Cashier.MONITOR){
            try {
                Cashier.MONITOR.wait();
                Util.sleep(1000);
                Cashier.MONITOR.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        Util.sleep(1000);
    }


}
