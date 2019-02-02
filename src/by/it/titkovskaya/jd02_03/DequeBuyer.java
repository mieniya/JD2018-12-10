package by.it.titkovskaya.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class DequeBuyer {

    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(20);

    static int getDequeSize(){
        return deque.size();
    }

    static void add(Buyer buyer, boolean pensioner) {
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Buyer poll() {
        if (deque.isEmpty()){
            return null;
        } else
        return deque.pollFirst();
    }
}
