package by.it.naron.jd01_08.oopShip;

 abstract class WarShip implements Ship {
    void shoot (){
        System.out.println("I can shoot");
    }
    @Override
    public void swim (){
        System.out.println("i can swim");
    }

     @Override
     public String toString() {
         return "this is class WarShip";
     }
 }
