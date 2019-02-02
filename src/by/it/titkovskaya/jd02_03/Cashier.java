package by.it.titkovskaya.jd02_03;

import java.util.concurrent.Semaphore;

public class Cashier implements Runnable {

    private String name;
    protected static boolean close = false;
    static double totalRevenue = 0;

    private static Semaphore semaphore = new Semaphore(1);

    public static void setClose(boolean close) {
        Cashier.close = close;
    }

    Cashier(int number) {
        name = "Cashier №" + number;
        Dispatcher.cashierNumber.incrementAndGet();
    }

    @Override
    public void run() {
        cashierAction(" opened");
        while (!Dispatcher.planComplete()) {
            cashierWorks();
        }
        cashierAction(" closed");
    }

    private void cashierWorks() {
        Buyer buyer = DequeBuyer.poll();
        if (buyer != null) {
            int timeout = Util.getRandom(2000, 5000);
            Util.sleep(timeout);
            addAmountBuyerSpentToTotalRevenue(buyer);
            try {
                semaphore.acquire();
                servesBuyerAndPrintCashVoucher(buyer, formBuyerCashVoucher(buyer));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            synchronized (buyer.getMonitor()) {
                buyer.iWait = false;
                buyer.notify();
            }
        } else {
            Util.sleep(1);
        }
    }

    private void cashierAction(String action) {
        if (this.name.contains("1")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , this + action, "", "", "", "", "", "");
        } else if (this.name.contains("2")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", this + action, "", "", "", "", "");
        } else if (this.name.contains("3")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", this + action, "", "", "", "");
        } else if (this.name.contains("4")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", "", this + action, "", "", "");
        } else if (this.name.contains("5")) {
            System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", "", "", this + action, "", "");
        } else System.out.println("Cashier is not identified!");
    }

    private void addAmountBuyerSpentToTotalRevenue(Buyer buyer) {
        Double buyerTotalSum = Buyer.buyerTotalSum.get(buyer);
        try {
            semaphore.acquire();
            totalRevenue += buyerTotalSum;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private String[] formBuyerCashVoucher(Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        sb.append("______________________").append(";");
        sb.append("  CHECK of ").append(buyer.toString().replace(" (pensioner)", "")).append(";");
        sb.append(Basket.buyersBaskets.get(buyer));
        sb.append("TOTAL: ").append(String.format("%.1f", Buyer.buyerTotalSum.get(buyer))).append("$").append(";");
        sb.append("______________________");
        return sb.toString().split(";");
    }

    private void servesBuyerAndPrintCashVoucher(Buyer buyer, String[] forCheck) {
        if (this.name.contains("1")) {
            System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                            "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , this + " is serving ", "", "", "", "", DequeBuyer.getDequeSize()
                    , totalRevenue
                    , buyer, "", "", "", "", "", "");
            for (String str : forCheck) {
                System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , str, "", "", "", "", "", "");
            }
        } else if (this.name.contains("2")) {
            System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                            "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", this + " is serving ", "", "", "", DequeBuyer.getDequeSize()
                    , totalRevenue
                    , "", buyer, "", "", "", "", "");
            for (String str : forCheck) {
                System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", str, "", "", "", "", "");
            }
        } else if (this.name.contains("3")) {
            System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                            "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", this + " is serving ", "", "", DequeBuyer.getDequeSize()
                    , totalRevenue
                    , "", "", buyer, "", "", "", "");
            for (String str : forCheck) {
                System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", str, "", "", "", "");
            }
        } else if (this.name.contains("4")) {
            System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                            "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", "", this + " is serving ", "", DequeBuyer.getDequeSize()
                    , totalRevenue
                    , "", "", "", buyer, "", "", "");
            for (String str : forCheck) {
                System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", "", str, "", "", "");
            }
        } else if (this.name.contains("5")) {
            System.out.printf("\n| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10.2f |\n" +
                            "| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                    , "", "", "", "", this + " is serving ", DequeBuyer.getDequeSize()
                    , totalRevenue
                    , "", "", "", "", buyer, "", "");
            for (String str : forCheck) {
                System.out.printf("| %-22s | %-22s | %-22s | %-22s | %-22s | %-10s | %-10s |\n"
                        , "", "", "", "", str, "", "");
            }
        } else System.out.println("Cashier is not identified!");
    }

    @Override
    public String toString() {
        return name;
    }
}
