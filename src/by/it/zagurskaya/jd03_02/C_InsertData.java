package by.it.zagurskaya.jd03_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C_InsertData {
    public void readСommands(Connection connection) throws SQLException {

        String filePath = getPath(C_InsertData.class, "cash_zagurskaya.sql");
        StringBuilder textFromFile = new StringBuilder();
        textFromFile = readTextFile(filePath, textFromFile);
        List<String> comandsInsertList = new ArrayList<>();
        comandsInsertList = readCommandsFromSqlToList(textFromFile);
        insertDataToTable(connection, comandsInsertList);
    }

    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }

    private static StringBuilder readTextFile(String path, StringBuilder textFromFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String value = br.readLine(); value != null; value = br.readLine()) {
                textFromFile.append(value).append('\n');
                int i = 0;
            }
            //  System.out.println("конец файла");
        } catch (IOException e) {
            System.err.println("что-то пошло не так, т.к. " + e.getMessage());
        }
        return textFromFile;
    }

    private static List<String> readCommandsFromSqlToList(StringBuilder text) {
        List<String> insertList = new ArrayList<>();
        char searchChar1 = 'I';
        char searchChar2 = 'N';
        char searchChar3 = 'S';
        char searchChar4 = 'E';
        char searchChar5 = 'R';
        char searchChar6 = 'T';
        char searchChar7 = ';';
        int i = 0;
        while (i < text.length() - 6) {
            if ((text.charAt(i) == searchChar1) & (text.charAt(i + 1) == searchChar2) & (text.charAt(i + 2) == searchChar3) & (text.charAt(i + 3) == searchChar4) & (text.charAt(i + 4) == searchChar5) & (text.charAt(i + 5) == searchChar6)) {
                int firstCharIndex = i;
                int j = i + 6;
                while (text.charAt(j) != searchChar7) {
                    j++;
                }
                int lastCharIndex = j;
                insertList.add(text.substring(firstCharIndex, lastCharIndex + 1));
            }
            i++;
        }
//        System.out.println(insertList);
        return insertList;
    }

    private void insertDataToTable(Connection connection, List<String> commands) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            for (String string : commands) {
                statement.executeUpdate(string);
            }
        }
    }
}
