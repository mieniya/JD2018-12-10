package by.it.moroz.jd02_02;

class Cashier implements Runnable {

    private String name;

    Cashier(int number) {
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        synchronized (Util.PRINTER) {
            System.out.println(this + " opened");
        }
        while (!Util.planComplete()) {
            Buyer pensioner = DequeBuyers.poll(DequeBuyers.pensionerDeque);
            if (pensioner != null) {
                serveTheBuyer(pensioner);
            } else {
                Buyer buyer = DequeBuyers.poll(DequeBuyers.buyerDeque);
                if (buyer != null)
                    serveTheBuyer(buyer);
                else Util.sleep(1);
            }
        }
        synchronized (Util.PRINTER) {
            System.out.println(this + " closed");
        }
    }

    private void serveTheBuyer(Buyer buyer) {
        int time = Util.getRandom(2000, 5000);
        Util.sleep(time);
        synchronized (Util.PRINTER) {
            System.out.println(this + " service " + buyer);
            buyer.takeCheck();
        }
        synchronized (buyer.getMonitor()) {
            buyer.notify();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
