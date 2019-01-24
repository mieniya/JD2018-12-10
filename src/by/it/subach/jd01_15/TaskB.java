package by.it.subach.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {
    /**
     * This program delete all JavaDocs
     *
     *
     *
     *
     *
     *
     * Or not delete =)
     * @param
     */

    static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        String simpleName = clazz.getSimpleName();
        path = path.replace(simpleName, "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir") + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    public static void main(String[] args) throws IOException {

        String path = getPath(TaskB.class, "TaskB.java");
        System.out.println(path);

//        oneRow comment also must be delete

        String testString1 = "/** Very smart JavaDoc*/\n great code. Fucking great CODE!!!";
        String testString2 = "// Very smart one row comment\n great code. Fucking great CODE again!!!";
        String testString3 = "/* Very smart many row comment \n*/\n great code. Fucking great CODE again and again!!!";

//        Stream<String> streamFromFiles = Files.b(Paths.get("TaskB.java")).filter("/*" :: equals);


/*
          and manyRow comments must die!!!

 */
    }
}
