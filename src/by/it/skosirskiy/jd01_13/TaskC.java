package by.it.skosirskiy.jd01_13;


import java.util.*;

public class TaskC {
    private static List<Double> list = new ArrayList<>();
    private static String chislo;

    public static void main(String[] args) throws Exception {
        Scanner scanner= new Scanner(System.in);
        int index=0;
        while (!(index==4)) {
            chislo=scanner.next();
            try {
                readData();

            }
            catch (Exception e){
                index++;
                Thread.sleep(100);
                Collections.reverse(list);
                for (Double element : list){
                    System.out.print(element+" ");
                }
                Collections.reverse(list);
                System.out.println();
            }
        }
        throw new Exception();
    }
    static void readData() throws Exception {
        try {
            list.add(Double.parseDouble(chislo));        }
        catch (Exception e){


            throw new Exception();

        }
    }
}