package by.it.zagurskaya.jd02_02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

class Cashier implements Runnable {

    private static Deque<Cashier> q = new LinkedBlockingDeque<>();
    private volatile static int index = 0;

    private String name;

    Cashier() {
        name = "Cashier №" + index++;
        q.addLast(this);
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.planComplete()) {

            synchronized (){
                if (/* если нужна подмога */) {
                    Thread cashier = new Thread(new Cashier());
                    cashier.start();
                }
            }

            synchronized (){
                if (/* если кассир лишний и не последний */) {
                    q.remove(this);
                    break;
                }
            }

            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {
                System.out.println(this + " service " + buyer);
                synchronized (buyer.getMonitor()) {
                    buyer.notify();
                }
            } else {
                Util.sleep(1);
            }
        }
        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return name;
    }

    public Thread getThread() {
        return Thread.currentThread();
    }

    public static Deque<Cashier> getQ() {
        return q;
    }
}
