package by.it.skosirskiy.jd02_01;



public class Util {
    static boolean buyersInMarket(int time){
        int n=Dispatcher.counterBuyer;

        if (time<30){
            if (n<=(time+10)) return true;
            else return false;
        }
        else if(n<=(40 + 30 - time)) {return true;}
            else return false;
    }

    static int getRandom(int min, int max){
        return min+(int)(Math.random()*(max-min+1));
    }

    static int getRandom(int max){
        return getRandom(0,max);
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
