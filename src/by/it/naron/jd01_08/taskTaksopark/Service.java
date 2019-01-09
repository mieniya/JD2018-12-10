package by.it.naron.jd01_08.taskTaksopark;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    //полей нет в этом классе



    //методы класса
    public static int stoimostAvtoparka(List<Avto> listAvtomobilei){

        int summa = 0;

        for (Avto imaPeremennoi : listAvtomobilei){
            summa+=imaPeremennoi.getPrice();
        }

        return summa;
    }

    public static List<Avto> poiskPoDiapozanyTseni (List<Avto> listAvtomobilei1, int min, int max){

        List<Avto> listAvto2 = new ArrayList<Avto>();

        for (Avto imaPeremennoi2 : listAvtomobilei1 ){
            if (imaPeremennoi2.getPrice()>=min && imaPeremennoi2.getPrice()<=max){
                listAvto2.add(imaPeremennoi2);
            }
        }

        return listAvto2;

    }

    // сортировка

    public static void sortirovkaPoRashodyTopliva(List<Avto> avtoSortirovka){

        Collections.sort(avtoSortirovka);




    }




}

