package by.it.subach.jd01_15;


import java.io.*;

public class TaskB {
    /**
     * This program delete all JavaDocs,
     * oneLine comments,
     * and manyLine comments...
     * Or not delete =)
     *
     * @param
     */

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();         //worked too
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }

/*
some comment 1

 */

    public static void main(String[] args) throws IOException {

        String path = getPath(TaskB.class, "TaskB.java");
        System.out.println(path);
        StringBuilder sb = new StringBuilder();

/*

some comment 2
 */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int c;
            while ((c = reader.read()) != -1) {
                if (c == 47) {
                    if (reader.read() == 47) {
                            while (reader.read() != 13) {
                                reader.read();
                        }
                    } else
                        while (reader.read() != 47) {
                            reader.read();
                        }
                }
                if (c != 47)
                    sb.append((char) c);
            }
//            some comment 3

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(TaskB.class, "TaskB.txt")));
        writer.write(sb.toString());
        writer.close();
//          some comment 4
        System.out.println(sb);
    }
}






