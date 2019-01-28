package by.it.moroz.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Market opened");
        GoodsInMarket.checkTheGoods(GoodsInMarket.goods);
        int num = 0;
        for (int i = 1; i <= 120; i++) {
            int count = Util.getRandom(0, 2);
            if (i < 30) {
                if(i<15){
                    for (int j = 0; j < 2; j++) {
                        newBuyer(++num);
                    }
                } else if (Util.counterBuyer <= i + 10) {
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            } else if (i < 60) {
                if (Util.counterBuyer <= 40 + (30 - i)) {
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            } else if (i < 90) {
                if(i<75){
                    for (int j = 0; j < 2; j++) {
                        newBuyer(++num);
                    }
                } else if (Util.counterBuyer <= i - 50) {
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            } else {
                if (Util.counterBuyer <=40+(90-i)){
                    for (int j = 0; j < count; j++) {
                        newBuyer(++num);
                    }
                }
            }
            System.out.println(i + " " + Util.counterBuyer);
            Util.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //while (Util.counterBuyer > 0)
        // Util.sleep(1);
        System.out.println("Market closed");
    }

    private static void newBuyer(int num) {
        Buyer buyer = new Buyer(num);
        if (num % 4 == 0)
            buyer.setPensioner(true);
        else buyer.setPensioner(false);
        buyers.add(buyer);
        Util.counterBuyer++;
        buyer.start();
    }
}
