package by.it.subach.jd02_09.TaskC;

import by.it.subach.jd02_09.beans.Users;

import java.io.*;

public class Runner {

    public static void main(String[] args) {

        String xmlIn = System.getProperty("user.dir") + "/src/by/it/subach/jd02_09/users+xsd.xml";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(xmlIn));
            StringBuilder sb = new StringBuilder();
            while (bufferedReader.ready()){
                sb.append(bufferedReader.readLine()).append("\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("===========================================XML TO JSON================================================");

        Converter convertToJson = ConvertFactory.getConvertFactory().getConverter(Direction.XML_TO_JSON, Users.class);
        convertToJson.load(new File(xmlIn));
        String jsonOut = convertToJson.getText();
        System.out.println(jsonOut);

        System.out.println("\n===========================================JSON TO XML================================================");

        Converter convertToXml = ConvertFactory.getConvertFactory().getConverter(Direction.JSON_TO_XML, Users.class);
        String xmlOut = System.getProperty("user.dir") + "/src/by/it/subach/jd02_09/TaskC/TaskC_out.xml";
        convertToXml.load(jsonOut);
        convertToXml.save(new File(xmlOut));
        System.out.println(convertToXml.getText());
    }
}
