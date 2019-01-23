package by.it.moroz.jd01_15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TaskA {

    public static void main(String[] args) {
        int [][] numbers = new int[6][4];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                numbers[i][j]= (int) (Math.random()*31-15);
            }
        }
        String fileName = System.getProperty("user.dir")+"/src/by/it/moroz/jd01_15";

        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName))){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
