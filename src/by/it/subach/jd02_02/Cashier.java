package by.it.subach.jd02_02;


class Cashier extends Thread implements Runnable {

    private String name;

    static final Object MONITOR = new Object();

    public Cashier(int number) {
        name = "Cashier №" + number;
    }

    Cashier getMonitor() {
        return this;
    }

    @Override
    public void run() {
        System.out.println(this + " opened");
        synchronized (this) {
            try {
                System.out.println(this + " go to sleep");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(this + " go to work");
            Util.sleep(1000);
        }
        while (!Dispatcher.planComplete()) {
            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {
                System.out.println(DequeBuyer.getQueueSize());
                System.out.println(this + " service " + buyer);
                int timeout = Util.getRandom(3000, 4000);        //500, 2000 по-умолчанию
                Util.sleep(timeout);
                synchronized (buyer.getMonitor()) {
                    buyer.notify();
                    Util.sleep(1);
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


    //    определяем сколько кассиров надо для обслуживания очереди
    private static int getCashiersNeeded(int queueSize) {

        if (queueSize > 20) return 5;
        if (queueSize > 15) return 4;
        if (queueSize > 10) return 3;
        if (queueSize > 5) return 2;
        if (queueSize > 0) return 1;

        return 0;

    }

    public static void cashiersManager(int queueSize) {
        System.out.println(queueSize);
        int cashiersNeeded = getCashiersNeeded(queueSize);


        if (Dispatcher.cashiersOnDuty < cashiersNeeded) {
            while (cashiersNeeded != Dispatcher.cashiersOnDuty) {
                Cashier cashier = Dispatcher.waitingCashiers.pollLast();           //берем кассира из очереди отдыхающих
                Dispatcher.workingCashiers.addFirst(cashier);                        //добавляем кассира в работающую очередь
                synchronized (Dispatcher.CASHIERS) {
                    Dispatcher.cashiersOnDuty++;
                    System.out.println(cashier.name + " go to work");
                    System.out.println("Cashiers on duty " + Dispatcher.cashiersOnDuty);
                    Dispatcher.CASHIERS.notify();
                    Util.sleep(1000);
                }

            }
        }

        if (cashiersNeeded < Dispatcher.cashiersOnDuty) {
            while (cashiersNeeded < Dispatcher.cashiersOnDuty) {
                Cashier cashier = Dispatcher.workingCashiers.pollLast();
                Dispatcher.waitingCashiers.addFirst(cashier);
                synchronized (Dispatcher.CASHIERS) {
                    try {
                        System.out.println(cashier.name + " go to sleep");
                        Dispatcher.CASHIERS.wait();
//                        cashier.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Dispatcher.cashiersOnDuty--;
                }
            }
        }
    }


}
