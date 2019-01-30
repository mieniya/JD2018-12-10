package by.it.subach.jd02_02;

public class Cashier extends Thread implements Runnable {

    private String name;

    static Object MONITOR = new Object();


    public Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        synchronized (MONITOR) {
            try {
                System.out.println(this + " go to sleep");
                MONITOR.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MONITOR.notify();
            Util.sleep(1000);
        }


        while (!Dispatcher.planComplete()) {
            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {
                System.out.println(this + " service " + buyer);
                int timeout = Util.getRandom(500, 200);
                Util.sleep(timeout);
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

    private void goToWork() {
        synchronized (MONITOR) {
            MONITOR.notify();
            Util.sleep(1000);
        }

    }


}
