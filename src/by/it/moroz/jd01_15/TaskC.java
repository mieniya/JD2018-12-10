package by.it.moroz.jd01_15;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        String startPos = getPath();
        System.out.println(startPos);
        File start = new File(startPos);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (!((command = scanner.nextLine()).equalsIgnoreCase("end"))){
            if (command.equals("cd ..")){
                start.getParentFile();
            }
            if (command.equals("dir")){

            }

        }
    }

    private static String getPath() {
        String path = TaskC.class.getName().replace(".", File.separator).replace(TaskC.class.getSimpleName(), "");
        return System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
    }
}
