package by.it.lyakhova.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {
    private static String txtOut = getPath(TaskC.class, "resultTaskC.txt");

    public static void main(String[] args) throws Exception {
        String dir =System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "lyakhova";
        watchFiles(dir);
    }

    private static void watchFiles(String dir){
        File path = new File(dir);
        String text = "";
        if(path.isDirectory()){
            File[] list = path.listFiles();
            if (list!=null) {
                for (File item : list) {
                    if (item.isDirectory()) {
                        text = "dir:" + item.getName();
                        System.out.println(text);
                        printToFile(txtOut, text);
                        watchFiles(item.getAbsolutePath());
                    } else {
                        text = "file:" + item.getName();
                        System.out.println(text);
                        printToFile(txtOut, text);
                    }
                }
            }
        }
    }

    private static void printToFile(String txtOut, String text) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(txtOut, true))) {
            writer.write(text+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> clazz, String filename) {
        //получаем информацию о классе
        String path = clazz.getName(); //полный путь к классу
        path = path.replace(clazz.getSimpleName(), "").replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }
}
