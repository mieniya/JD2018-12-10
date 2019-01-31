package by.it.subach.jd02_02;

public class Cashier extends Thread implements Runnable {

    private String name;

    static Object MONITOR = new Object();

    public Cashier(int number) {
        name = "Cashier №" + number;
    }
    public Cashier getCashier(){
        return this;
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
            System.out.println(this + " go to work");
            Util.sleep(1000);
            MONITOR.notify();           //что бы отдать монитор
        }

        while (!Dispatcher.planComplete()) {
            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {
                System.out.println(this + " service " + buyer);
                int timeout = Util.getRandom(1000, 4000);        //500, 2000 по-умолчанию
                Util.sleep(timeout);
                synchronized (buyer.getMonitor()) {
                    buyer.notify();
                    Util.sleep(1000);

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




}
