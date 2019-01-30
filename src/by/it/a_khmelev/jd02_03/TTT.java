package by.it.a_khmelev.jd02_03;

public class TTT extends Thread{

    @Override
    public void run() {
        try {
            sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new TTT().start();
            if (i % 1000==0)
                System.out.println(i);
        }
        System.out.println("all");
    }
}
