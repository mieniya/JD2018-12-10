package by.it.titkovskaya.jd02_09.converter;

import by.it.titkovskaya.jd02_09.beans.Clients;
import java.io.File;

public class Runner {

    public static void main(String[] args) {

        File xmlSource = new File((new Path()).getPath(Converter.class, "clients+xsd.xml"));
        File jsonFile = new File((new Path()).getPath(Converter.class, "json.json"));
        File xmlOutput = new File((new Path()).getPath(Converter.class, "outputXML.xml"));

        ConverterFactory factory = new ConverterFactory<>();

        Converter converter = factory.getConverter(Direction.XML_TO_JSON, Clients.class);
        converter.load(xmlSource);
        converter.save(converter.getText(),jsonFile);

        converter = factory.getConverter(Direction.JSON_TO_XML, Clients.class);
        converter.load(jsonFile);
        converter.save(converter.getText(),xmlOutput);
    }

}
