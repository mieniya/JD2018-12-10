package by.it.subach.jd01_15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskC {

    static String currentPath = getPath(TaskC.class, "");

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([cd]) (\\w+)");
        System.out.println(currentPath);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String str = scanner.nextLine();
            Matcher matcher = pattern.matcher(str);

            if (str.equals("cd ..")){
                System.out.println(getParentDir(currentPath));
            }

            if(matcher.find()){
                String name = matcher.group(2);
                System.out.println(getSomeDir(name));
            }

            if(str.equals("dir")){
                viewDirectory(currentPath);
            }

            if (str.equalsIgnoreCase("end")) break;
        }
    }

    private static void viewDirectory(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            long lastMod = f.lastModified();
            Date date = new Date(lastMod);
            SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy  hh:mm");
            String out = format.format(date);
            System.out.println(out);


        }
//        String[] list = file.list();
//        for (String s : list) {
//
//            System.out.println(s);
//        }

    }

    private static String getParentDir(String path){
        File parentDir = new File(path);
        currentPath = parentDir.getParent();
        if(currentPath == null){
            return "You are in root directory";
        }
        return currentPath;
    }

    private static String getSomeDir (String name){
        currentPath = currentPath + File.separator + name;
        return currentPath;
    }


    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }


}
