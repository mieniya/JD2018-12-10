package by.it.titkovskaya.jd02_02;

import java.util.LinkedList;
import java.util.List;

public class CashDeskManager extends Thread {

    private static List<Thread> threads = new LinkedList<>();
    static int cashDeskNumber = 1;
    private static int cashDeskOpened = 0;

    @Override
    public void run() {
        int cashiersToStart = 2;
        cashDeskOpening(cashiersToStart);

        while (Dispatcher.marketOpened()) {
            if (checkCashDeskRequired()) {
                cashDeskOpening(cashDesksRequired());
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void cashDeskOpening(int cashDesksRequired) {
        for (int i = cashDeskNumber; i <= cashDesksRequired; i++) {
            Thread cashier = new Thread(new Cashier(i));
            threads.add(cashier);
            cashDeskNumber++;
            cashDeskOpened++;
            cashier.start();
        }
    }

    private static boolean checkCashDeskRequired() {
        if (cashDeskOpened == cashDesksRequired()) {
            Cashier.setClose(false);
            return false;
        } else if (cashDeskOpened < cashDesksRequired()) {
            Cashier.setClose(false);
            return true;
        } else if (cashDeskOpened > cashDesksRequired()) {
            Cashier.setClose(true);

            cashDeskOpened--;
            return false;
        } else return false;
    }

    private static int cashDesksRequired() {
        int deque = DequeBuyer.getTotalDequeSize();
        if (deque <= 5) return 1;
        else if (deque > 10 && deque <= 15) return 2;
        else if (deque > 15 && deque <= 20) return 3;
        else if (deque > 20 && deque <= 25) return 4;
        else if (deque > 25) return 5;
        else return 0;
    }

}
