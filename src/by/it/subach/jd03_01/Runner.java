package by.it.subach.jd03_01;

import java.util.Scanner;

public class Runner {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printOptions();
        while(true){
            String input = scanner.nextLine();
            if(input.equals("1")){
                C_Reset.resetDB();
            }
            else if(input.equals("2")){
                C_Init.initDB();
            }
            else if(input.equals("3"))
                break;
            else
                printOptions();
        }
    }

    private static void printOptions(){
        System.out.println("Select an option:");
        System.out.println("1. Remove DataBase (1)");
        System.out.println("2. Restore DataBase (2)");
        System.out.println("3. Exit (3)");
    }

}
