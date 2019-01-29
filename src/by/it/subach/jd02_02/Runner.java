package by.it.subach.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Runner {
    private static List<Thread> threads = new ArrayList<>();
//    static int number = 0;


    public static void main(String[] args) {
        Util.fillPriceList(Util.priceList);
        System.out.println("Раскладываем товар по полкам");
        System.out.println(Util.priceList.toString());
        System.out.println("Market is opened");

        int number = 0;
        for (int i = 1; i <= 2; i++) {
            Thread cashier = new Thread(new Cashier(i));
            threads.add(cashier);
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
                Util.sleep(1000);
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

//        for (int time = 0; time < 120; time++) {
//            if (time > 0 && time % 10 == 0) {
//                System.out.println("        " + Dispatcher.getCounterBuyer() + " покупателей на " + time + " сек.");
//            }
//            int count;
//            if (time <= 30) {
//                count = (time + 10) - Dispatcher.counterBuyer;
//                addBuyers(count);
//            }
//            if (time > 30 && time <= 60) {
//                count = 40 - (time - 30) - Dispatcher.counterBuyer;
//                addBuyers(count);
//            }
//
//            if (time > 60 && time <= 90) {
//                count = ((time + 10) - 60) - Dispatcher.counterBuyer;
//                addBuyers(count);
//            }
//            if (time > 90) {
//                count = (40 - (time - 30 - 60)) - Dispatcher.counterBuyer;
//                addBuyers(count);
//            }
//
//        }
//
//
//        while (Dispatcher.counterBuyer > 0) {
//            Util.sleep(1);
//            Thread.yield();
//
//        }
//
//        System.out.println("Market closed");
//        System.out.println("Всего покупателей: " + buyers.size());
//        System.out.println("Пенсионеров приходило: " + Buyer.pens);
//    }

//    private static void addBuyers(int count) {
//        for (int i = 0; i < count; i++) {
//            Buyer buyer = new Buyer(++number);
//            buyers.add(buyer);
//            buyer.start();
//            Dispatcher.counterBuyer++;
//        }
//        Util.sleep(1000 / Dispatcher.K_SPEED);
//
//    }

    }
}
