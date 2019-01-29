package by.it.subach.jd02_02;

class Dispatcher {

    static final int K_SPEED = 100;
    private static volatile int counterBuyerInShop = 0;
    private static volatile int counterBuyerComplete = 0;
    private static final Object MON = new Object();
    private static final int plan = 100;

    static void newBuyer(){
        synchronized (MON){
            counterBuyerInShop++;
        }
    }

    static void buyerComplete(){
        synchronized (MON){
            counterBuyerInShop--;
            counterBuyerComplete++;
        }
    }

    static boolean planComplete(){
        synchronized (MON){
            return counterBuyerComplete >= plan;
        }
    }

    static boolean marketOpen(){
        synchronized (MON){
            return counterBuyerInShop + counterBuyerComplete < plan;
        }
    }


//  постараться убрать эту переменную и метод
    static volatile int counterBuyer = 0;

    static synchronized int getCounterBuyer(){
        return counterBuyer;
    }
}