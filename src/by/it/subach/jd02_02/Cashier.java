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
        Dispatcher.waitingCashiers.addFirst(this);
        synchronized (this) {
            try {
                System.out.println(this + " go to sleep");
//                System.out.println(Dispatcher.waitingCashiers.toString());
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(this + " go to work");
            Util.sleep(1000);
        }
        while (!Dispatcher.planComplete()) {


//            while (cashiersNeeded < Dispatcher.cashiersOnDuty) {
//                synchronized (this) {
//                    try {
//                        this.wait();
//                        System.out.println(this + " wait");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

            Buyer buyer = DequeBuyer.poll();
            if (buyer != null) {
                int cashiersNeeded = getCashiersNeeded(DequeBuyer.getQueueSize());

                if (Dispatcher.cashiersOnDuty < cashiersNeeded) {
                    while (cashiersNeeded != Dispatcher.cashiersOnDuty) {
                        synchronized (this) {
                            this.notify();
                        }
                    }

                    Util.sleep(1000);
                }
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

    private void goToWork() {
        synchronized (this) {
            this.notify();
            Dispatcher.workingCashiers.addFirst(this);                        //добавляем кассира в работающую очередь
            Dispatcher.cashiersOnDuty++;
            System.out.println(this + " go to work");
            System.out.println("Cashiers on duty " + Dispatcher.cashiersOnDuty);
        }
    }

    private void goToSleep() {
        Dispatcher.waitingCashiers.addFirst(this);
        System.out.println("            " + Dispatcher.waitingCashiers.toString());
        System.out.println("            " + Dispatcher.workingCashiers.toString());

        synchronized (this) {
            try {
                System.out.println("    " + this);
                this.wait();
                Dispatcher.cashiersOnDuty--;
                System.out.println(this.name + " go to sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void cashiersManager(int queueSize) {
        System.out.println(queueSize);
//        int cashiersNeeded = getCashiersNeeded(queueSize);
//
//        if (Dispatcher.cashiersOnDuty < cashiersNeeded) {
//            while (cashiersNeeded != Dispatcher.cashiersOnDuty) {
//                Cashier cashier = Dispatcher.waitingCashiers.removeLast();  //берем кассира из очереди отдыхающих
//                cashier.goToWork();
//            }
//            System.out.println(Dispatcher.waitingCashiers.toString());
//            System.out.println(Dispatcher.workingCashiers.toString());
//
//            Util.sleep(1000);
//        }
//
//        while (cashiersNeeded < Dispatcher.cashiersOnDuty) {
//            while (cashiersNeeded < Dispatcher.cashiersOnDuty) {
//                Cashier cashier = Dispatcher.workingCashiers.removeFirst();
//                cashier.goToSleep();
//            }
//        }
    }


}
