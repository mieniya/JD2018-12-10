package by.it.kushnerov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market is open");
        int number = 0;
        for (int time = 0; time <= 120; time++) {
            int count = Util.getRandom(2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                buyers.add(buyer);
                Dispatcher.counterBuyer++;
                buyer.start();
            }
            Util.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market closed");
    }
}
