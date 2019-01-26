package by.it.yarmolenka.jd02_01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runner {
    private static LinkedList<Integer> numberOfBuyers = new LinkedList<>();
    private static List<Buyer> listOfBuyers = new ArrayList<>();

    public static void main(String[] args) {
        Goods.load();
        System.out.println("Market is open");
        int number = 1;
        for (int i = 1; i <= 120; i++) {
            int sec = i % 60;
            int num = -1;
            if (sec <= 30) {
                if (Dispatcher.buyersCount < sec + 10) num = 2;
            } else {
                if (Dispatcher.buyersCount > (40 + 30 - sec)) num = 0;
            }
            if (num == -1) num = Utils.getRandom(0, 2);
            for (int j = 0; j < num; j++) {
                Buyer buyer;
                if (number % 4 == 0)
                    buyer = new Buyer(number++, true);
                else
                    buyer = new Buyer(number++);
                listOfBuyers.add(buyer);
                buyer.start();
            }
            numberOfBuyers.offerFirst(Dispatcher.buyersCount);
            Utils.sleep(1000/500);
        }
        for (Buyer buyer : listOfBuyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
        System.out.println("Buyers in Market Statistics:");
        int n = listOfBuyers.size();
        for (int i = 1; i <= n; i++) {
            System.out.printf("second %d, number of buyers %d\n", i, numberOfBuyers.pollLast());
        }
    }
}
