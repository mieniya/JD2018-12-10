package by.it.moroz.jd02.jd02_09;

import by.it.moroz.jd02.jd02_09.beans.Users;

public class Runner {

    public static void main(String[] args) {

        String xml = System.getProperty("user.dir")+"/src/by/it/moroz/jd02_09/users+xsd.xml";

        ConverterFactory factory = new ConverterFactory();
        Converter xmlToJson = factory.getConventer(Direction.XML_TO_JSON, Users.class);
        xmlToJson.load(xml);
        String json = xmlToJson.getText();
        //Converter jsonToXml = factory.getConventer(Direction.JSON_TO_XML, Users.class);
        //jsonToXml.load(json);
        System.out.println(json);
    }
}
