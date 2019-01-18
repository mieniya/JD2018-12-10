package by.it.naron.jd01_08.taskTaksopark;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {                                     //таксопарк название метода
    public static void main(String[] args) {

        //создание объекта
        Taxi taxiCarVolga = new Taxi(9000,11.5,"Petrol",4,2,true);
        AvariinieAvto carMedichine = new AvariinieAvto(5000,6.2,"Diezel",4,2,false,false,true);
        GonochnieAvto carFerrari = new GonochnieAvto(25000,15.6,"Petrol",2,1,true);
        Furi furaMan = new Furi(40000,12500.8,"Diezel",2,2,32000,10,true);
        Samosval samosvalZil = new Samosval(16000,18.3,"Gaz-Petrol",3,1,3650,6,true);
        Kran kranMaz = new Kran(2300,19.8,"Diezel",2,1,11000,6,true);

        List<Avto> listIzAvtomobilei = new ArrayList<Avto>();
        listIzAvtomobilei.add(taxiCarVolga);
        listIzAvtomobilei.add(carMedichine);
        listIzAvtomobilei.add(carFerrari);
        listIzAvtomobilei.add(furaMan);
        listIzAvtomobilei.add(samosvalZil);
        listIzAvtomobilei.add(kranMaz);

        System.out.println(Service.stoimostAvtoparka(listIzAvtomobilei));    // стоимость автопарка

        System.out.println(Service.poiskPoDiapozanyTseni(listIzAvtomobilei, 2000, 30000));

        Service.sortirovkaPoRashodyTopliva(listIzAvtomobilei);
        System.out.println(listIzAvtomobilei);

//        System.out.println("стоимость автопарка "+(taxiCarVolga.getPrice()+carMedichine.getPrice()+carFerrari.getPrice()+
//                furaMan.getPrice()+samosvalZil.getPrice()+kranMaz.getPrice()));
//
//        int i = taxiCarVolga.getPrice()+carMedichine.getPrice()+carFerrari.getPrice()+
//                furaMan.getPrice()+samosvalZil.getPrice()+kranMaz.getPrice();
//
//        System.out.println(i);



    }
}
