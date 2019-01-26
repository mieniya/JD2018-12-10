package by.it.subach.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market is opened");
        int number = 0;
        for (int time = 1; time < 120; time++) {
            int count = Util.getRandom(0, 2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
            }
            Util.sleep(1000/Dispatcher.K_SPEED);
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
