package by.it.subach.jd02_08;

import javax.xml.stream.XMLInputFactory;
import java.io.*;

public class StAXParser {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/by/it/subach/jd02_07/Users.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (
            Reader reader =  new BufferedReader(
                    new FileReader(path)
            )
        ) {

        } catch (IOException e) {
            e.printStackTrace();
        }

//        xmlInputFactory.createXMLStreamReader()

    }
}
