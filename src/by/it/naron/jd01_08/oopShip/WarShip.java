package by.it.naron.jd01_08.oopShip;

 abstract class WarShip implements Ship {
     int distance;

    void shoot (int distance){
        this.distance=distance;
        System.out.println("I can shoot - "+distance+" distance");
    }


     @Override
     public String toString() {
         return "this is class WarShip";
     }
 }
