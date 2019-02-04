package by.it.migunko.calc_tests;
import java.io.File;
public class Log {

    static String getPath(Class<?> clazz) {
        String simpleName = clazz.getSimpleName();
        String path = clazz.getName().replace(simpleName, "");
        path = path.replaceAll("\\.", File.separator);
        String root = System.getProperty("user.dir");
        String result = root + File.separator + "src" + File.separator + path;
        return result;
    }

    static String getPath() {
        return getPath(Log.class);
    }

    static String getPath(String fileName) {
        return getPath() + fileName;
    }

}
