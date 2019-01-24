package by.it.yarmolenka.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskC {
    public static void main(String[] args) throws IOException {
        String pathToRoot = TaskA.getPath(TaskC.class);
        File f = new File(pathToRoot);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!((input = reader.readLine()).equalsIgnoreCase("end"))){
            if (input.equals("cd ..")){
                f = f.getParentFile();
            } else if (input.matches("cd [a-zA-Z0-9._]+")){
                System.out.println("zaebok");
            } else if (input.equals("dir")){
                File[] files = f.listFiles();
                for (File file : files) {
                    Path path = Paths.get(file.getAbsolutePath());
                }
            }
        }
    }
}
