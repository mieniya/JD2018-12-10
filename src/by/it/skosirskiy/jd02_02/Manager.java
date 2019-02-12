package by.it.skosirskiy.jd02_02;

public class Manager extends Thread{
    private final Object lock = new Object();
    private int workingCashiers=0;
    @Override
    public void run() {



        for (int i = 1; i < 6; i++) {
            Cashier cashier = new Cashier(i);
            Runner.cashiers.add(cashier);
            cashier.start();

        }
        while (!Dispatcher.marketClosed()) {

            int n = neededNumOfCashiers();
          //  System.out.println("Size "+DequeBuyer.getSize());
         //   System.out.println("marketClosed "+n);
            if(n==this.workingCashiers) {
          //      System.out.println("workingCashiers "+workingCashiers);
                Util.sleep(1000);
                continue;
            }
            if(workingCashiers<n){
                for (Cashier cashier:Runner.cashiers) {
                    if(workingCashiers==n) break;
                    if(cashier.getStatus()) {
                        this.workingCashiers++;
                        cashier.goToWork();
                    }
                }
                continue;
            }
            if(workingCashiers>n){
                for (Cashier cashier:Runner.cashiers) {
                    if(workingCashiers==n) break;
                    if(!(cashier.getStatus())) {
                        this.workingCashiers--;
                        cashier.close=true;
                    }
                }
            }
            Util.sleep(2000);
        }
        for (Cashier cashier:Runner.cashiers) {
            cashier.close();
        }



    }
    private static int neededNumOfCashiers(){
        int dequeSize = DequeBuyer.getSize();
        if(dequeSize<=5) return 1;
        if(dequeSize>5&&dequeSize<=10) return 2;
        if(dequeSize>10&&dequeSize<=15) return 3;
        if(dequeSize>15&&dequeSize<=20) return 4;
        if(dequeSize>20) return 5;
        return 0;
    }

}
